package core.basesyntax;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime startTime = LocalTime.now();
        Thread.sleep(new Random().nextInt(1000));
        LocalTime endTime = LocalTime.now();
        long duration = Duration.between(startTime, endTime).toMillis();
        return String.format("Task duration was %d ms, execution finished at %s", duration, endTime);
    }
}
