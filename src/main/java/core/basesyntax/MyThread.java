package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int randomSleepTime = random.nextInt(501);

        Thread.sleep(randomSleepTime);

        return "Task duration was "
                + randomSleepTime
                + " ms, execution finished at "
                + LocalTime.now();
    }
}
