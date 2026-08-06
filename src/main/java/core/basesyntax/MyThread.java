package core.basesyntax;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random RANDOM = new Random(47);

    @Override
    public String call() throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        Thread.sleep(RANDOM.nextInt(1000));
        LocalDateTime finish = LocalDateTime.now();
        long duration = Duration.between(start, finish).toMillis();
        return String.format("Task duration was %s ms, execution finished at %s", duration, finish);
    }
}
