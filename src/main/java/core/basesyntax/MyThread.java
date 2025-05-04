package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long sleepingDuration = new Random().nextInt(200);
        Thread.sleep(sleepingDuration);
        return String.format("Task duration was %d ms, execution finished at %s",
                sleepingDuration, LocalTime.now());
    }
}
