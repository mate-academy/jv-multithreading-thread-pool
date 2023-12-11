package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        long randomNum = random.nextInt(500);
        LocalTime now = LocalTime.now();
        return String.format("Task duration was %d ms, execution finished at %s", randomNum, now);
    }
}
