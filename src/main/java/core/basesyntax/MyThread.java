package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        int ms = (new Random().nextInt(10) + 1) * 100;
        Thread.sleep(ms);

        return "Task duration was " + ms + " ms, execution finished at " + LocalTime.now();
    }
}
