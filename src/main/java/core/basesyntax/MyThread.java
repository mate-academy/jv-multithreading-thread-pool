package core.basesyntax;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();
    @Override
    public String call() throws InterruptedException {
        // write your code here
        Instant instantBegin = Instant.now();
        long val = random.nextLong();
        if (val < 0) {
            val *= -1;
        }
        val %= 400;
        val += 100;
        Thread.sleep(val);
        Instant instantEnd = Instant.now();
        Duration duration = Duration.between(instantBegin, instantEnd);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration.toMillis(), LocalDateTime.now());
    }
}
