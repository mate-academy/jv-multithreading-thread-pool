package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        long time = (long) (Math.random() * 1000 + 100);
        Thread.sleep(time);
        return "Task duration was " + time + " ms, execution finished at " + LocalTime.now();
    }
}
