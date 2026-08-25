package core.basesyntax;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(500);
        LocalTime end = LocalTime.now();
        long duration = Duration.between(start, end).toMillis();

        return String.format("Task duration was %s ms, execution finished at %s",
                duration,
                end
        );
    }
}
