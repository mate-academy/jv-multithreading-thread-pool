package core.basesyntax;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(100);
        LocalTime end = LocalTime.now();
        Duration duration = Duration.between(start, end);
        long millis = duration.toMillis();
        return String.format("Task duration was %d ms, execution finished at ", millis)
                    + LocalTime.now();
    }
}
