package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long duration = ThreadLocalRandom.current().nextLong(100, 1000);

        Thread.sleep(duration);

        LocalDateTime finishTime = LocalDateTime.now();

        return String.format("Task duration was %d ms, execution finished at %s",
                duration, finishTime);
    }
}
