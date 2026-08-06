package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MIN_DURATION = 100;
    private static final int MAX_DURATION = 500;

    @Override
    public String call() throws InterruptedException {
        int duration = new Random().nextInt(MAX_DURATION - MIN_DURATION + 1) + MIN_DURATION;
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, LocalTime.now().toString());
    }
}
