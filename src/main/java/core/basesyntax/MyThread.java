package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        // write your code here
        long val = (random.nextInt(5) + 1) * 100L;
        Thread.sleep(val);
        return String.format("Task duration was %d ms, execution finished at %s",
                val, LocalDateTime.now());
    }
}
