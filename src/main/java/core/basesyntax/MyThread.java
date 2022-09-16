package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long duration = ThreadLocalRandom.current().nextLong(100);
        Thread.sleep(duration);
        return "Task duration was " + duration + "ms, execution finished at "
                + LocalDateTime.now();
    }
}
