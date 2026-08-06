package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MAX_TIME_TO_SLEEP_MS = 500;

    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int timeToSleep = random.nextInt(MAX_TIME_TO_SLEEP_MS);
        Thread.sleep(timeToSleep);
        return String.format("Task duration was %d ms, execution finished at %s",
                timeToSleep, LocalTime.now());
    }
}
