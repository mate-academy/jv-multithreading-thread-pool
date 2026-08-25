package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        long duration = ThreadLocalRandom.current().nextLong(1, 5) * 100;
        Thread.sleep(duration);
        return String.format("Task duration was " + duration
                + " ms, execution finished at "
                + LocalDateTime.now());
    }
}
