package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MIN_DURATION = 100;
    private static final int MAX_DURATION = 500;
    private static final Random RANDOM = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = RANDOM.nextInt(MAX_DURATION - MIN_DURATION + 1) + MIN_DURATION;
        Thread.sleep(taskDuration);
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, LocalTime.now());
    }
}
