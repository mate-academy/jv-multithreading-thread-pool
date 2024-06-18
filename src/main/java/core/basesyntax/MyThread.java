package core.basesyntax;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MAX_SLEEP_TIME = 500;
    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(new Random().nextInt(MAX_SLEEP_TIME));
        LocalTime end = LocalTime.now();
        long duration = ChronoUnit.MILLIS.between(start, end);
        return "Task duration was %d ms, execution finished at %s"
                .formatted(duration, end);
    }
}
