package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long duration = ThreadLocalRandom.current().nextLong(200L);
        Thread.sleep(duration);
        LocalTime time = LocalTime.now();
        return "Task duration was " + duration + " ms, execution finished at " + time.toString();
    }
}
