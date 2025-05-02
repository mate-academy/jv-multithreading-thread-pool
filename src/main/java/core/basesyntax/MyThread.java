package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MILLS = 100;
    private static final int BOUND = 6;
    private static final int COEFFICIENT = 1;

    @Override
    public String call() throws InterruptedException {
        int duration = Math.abs((new Random().nextInt(BOUND) + COEFFICIENT) * MILLS);
        Thread.sleep(duration);
        return "Task duration was " + duration
                + "ms" + ", execution finished at " + LocalTime.now();
    }
}
