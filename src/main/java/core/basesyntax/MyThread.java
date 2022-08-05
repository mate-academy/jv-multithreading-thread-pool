package core.basesyntax;

import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime startTime = LocalTime.now();
        Thread.sleep(new Random().nextInt(250) + 50);
        LocalTime finishTime = LocalTime.now();
        return String.format("Task duration was %d ms, execution finished at %s",
                MILLIS.between(startTime, finishTime), finishTime);
    }
}
