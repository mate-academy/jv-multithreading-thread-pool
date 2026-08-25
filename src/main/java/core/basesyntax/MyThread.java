package core.basesyntax;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public String call() throws InterruptedException {
        // write your code here
        Thread.sleep(1000);
        return null;
    }
}
