package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = ThreadLocalRandom.current().nextInt(1, 6) * 100;
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, LocalDateTime.now());
    }
}
