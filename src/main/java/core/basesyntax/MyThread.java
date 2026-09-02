package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    private static final int MIN_DURATION = 100;
    private static final int MAX_DURATION = 500;
    private static final int DURATION_STEP = 100;

    @Override
    public String call() throws InterruptedException {
        int duration = ThreadLocalRandom.current().nextInt(
                MIN_DURATION / DURATION_STEP,
                MAX_DURATION / DURATION_STEP + 1
        ) * DURATION_STEP;

        Thread.sleep(duration);

        return String.format(
                "Task duration was %d ms, execution finished at %s",
                duration,
                LocalTime.now()
        );
    }
}
