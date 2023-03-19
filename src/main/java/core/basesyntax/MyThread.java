package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int SLEEP_MAX_RANGE = 500;

    @Override
    public String call() throws InterruptedException {
        int randomDelay = new Random().nextInt(SLEEP_MAX_RANGE);
        Thread.sleep(randomDelay);
        return "Task duration was " + randomDelay
                + " ms, execution finished at " + LocalTime.now();
    }
}
