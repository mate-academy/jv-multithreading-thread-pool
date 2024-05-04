package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomSleepTime = randomSleepTime();
        Thread.sleep(randomSleepTime);
        return "Task duration was " + randomSleepTime
                + " ms, execution finished at " + LocalTime.now();
    }

    private int randomSleepTime() {
        return (new Random().nextInt(5) + 1) * 100;
    }
}
