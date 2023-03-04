package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long taskDuration = ThreadLocalRandom.current().nextLong(100L, 500L);
        Thread.sleep(taskDuration);
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, LocalTime.now().toString());
    }
}
