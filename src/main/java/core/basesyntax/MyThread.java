package core.basesyntax;

import static java.lang.Thread.sleep;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random RANDOM = new Random();
    private static final int MAX_DURATION = 1000;

    @Override
    public String call() throws InterruptedException {
        int duration = RANDOM.nextInt(MAX_DURATION);
        sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration,
                LocalTime.now());
    }
}
