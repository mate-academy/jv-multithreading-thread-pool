package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    private final String message = "Task duration was %d ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        long executionTime = ThreadLocalRandom.current().nextLong(200L);
        Thread.sleep(executionTime);
        return String.format(message, executionTime, LocalTime.now());
    }
}
