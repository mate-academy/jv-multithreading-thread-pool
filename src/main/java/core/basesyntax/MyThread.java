package core.basesyntax;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(new Random().nextInt(500));
        LocalTime end = LocalTime.now();
        return String.format("Task duration was %s ms, execution finished at %s",
                ChronoUnit.MILLIS.between(start, end), end);
    }
}
