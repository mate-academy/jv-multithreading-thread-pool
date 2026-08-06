package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int RANDOM_BOUND = 500;

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(100);
        return "Task duration was " + new Random().nextInt(RANDOM_BOUND)
                + " ms, execution finished at " + LocalTime.now();
    }
}
