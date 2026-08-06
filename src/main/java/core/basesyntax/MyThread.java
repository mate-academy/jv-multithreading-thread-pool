package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random;
    private final int bound;

    public MyThread(Random random, int bound) {
        this.random = random;
        this.bound = bound;
    }

    @Override
    public String call() throws InterruptedException {
        long duration = random.nextInt(bound);
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s", duration,
                LocalTime.now());
    }
}
