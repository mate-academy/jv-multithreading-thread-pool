package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random RANDOM = new Random();

    @Override
    public String call() throws InterruptedException {
        long duration = (RANDOM.nextInt(4) + 1) * 100L;
        Thread.sleep(duration);
        return "Task duration was " + duration + " ms, execution finished at " + LocalTime.now();
    }
}
