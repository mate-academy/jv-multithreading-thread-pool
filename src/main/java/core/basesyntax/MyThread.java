package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(500));
        long finishTime = System.currentTimeMillis();
        long differenceTime = finishTime - startTime;
        return String.format("Task duration was %s ms, execution finished at %s",
                differenceTime, LocalTime.now());
    }
}
