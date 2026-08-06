package core.basesyntax;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime beforeExecution = LocalTime.now();
        Thread.sleep(new Random().nextInt(901) + 100);
        LocalTime afterExecution = LocalTime.now();

        long durationInMilliseconds = TimeUnit.NANOSECONDS.toMillis(
                beforeExecution.until(afterExecution, ChronoUnit.NANOS));

        return String.format("Task duration was %d ms, execution finished at "
                + afterExecution, durationInMilliseconds);
    }
}
