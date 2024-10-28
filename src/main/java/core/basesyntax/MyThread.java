package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int RANDOM_BOUND = 1000;
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(random.nextInt(RANDOM_BOUND));
        return String.format("Task duration was %s ms, execution finished at %s%n",
                RANDOM_BOUND,
                LocalTime.now());
    }
}
