package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(200);
        //System.out.println("My name is " + Thread.currentThread().getName());
        return "Task duration was 200 ms, execution finished at " + LocalDateTime.now();
    }
}
