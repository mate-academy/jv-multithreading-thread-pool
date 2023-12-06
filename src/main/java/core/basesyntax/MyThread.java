package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep((random.nextInt(5) + 1) * 100);
        LocalTime endTime = LocalTime.now();
        long end = System.currentTimeMillis();
        long duration = (end - start);
        return String.format("Task duration was %s ms, execution finished at %s",
                duration, endTime);
    }
}
