package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();
    private static final int MIN_DURATION_MS = 100;
    private static final int MAX_DURATION_MS = 500;

    @Override
    public String call() throws InterruptedException {
        // write your code here
        int duration = random.nextInt(MAX_DURATION_MS - MIN_DURATION_MS + 1)
                + MIN_DURATION_MS;
        Thread.sleep(duration);
        LocalTime finishTime = LocalTime.now();
        return String.format("Task duration was %d ms, execution finished at %s",
                duration,
                finishTime.toString());
    }
}
