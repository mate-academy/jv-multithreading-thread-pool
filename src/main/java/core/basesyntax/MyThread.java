package core.basesyntax;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(random.nextInt(1000));
        LocalTime end = LocalTime.now();
        long duration = ChronoUnit.MILLIS.between(start, end);
        return String.format("Task duration was %d, execution finished at %s", duration, end);
    }
}
