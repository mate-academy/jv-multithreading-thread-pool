package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = ThreadLocalRandom.current().nextInt(100, 500);
        Thread.sleep(duration);
        LocalDateTime now = LocalDateTime.now();
        return "Task duration was: " + duration + " ms, execution finished at " + now;
    }
}
