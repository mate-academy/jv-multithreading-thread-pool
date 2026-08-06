package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        int sleepTime = Integer.parseInt(threadName.substring(
                threadName.length() - 1)) * 100;
        Thread.sleep(sleepTime);
        return "Task duration was " + sleepTime
                + ", execution finished at " + LocalTime.now();
    }
}
