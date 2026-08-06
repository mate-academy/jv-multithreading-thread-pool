package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long sleepTime = (long) (Math.random() * 500);
        Thread.sleep(sleepTime);
        return String.format("Task duration was %d ms, execution finished at %s",
                sleepTime, LocalTime.now());
    }
}
