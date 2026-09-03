package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int BASE_DURATION_MS = 100;
    private static final int MAX_MULTIPLIER = 5;

    @Override
    public String call() throws InterruptedException {
        int duration = (new Random().nextInt(MAX_MULTIPLIER) + 1) * BASE_DURATION_MS;
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, LocalTime.now());
    }
}
