package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public synchronized String call() throws InterruptedException {
        int randomSleepTime = random.nextInt(200);
        wait(randomSleepTime);
        LocalTime localTime = LocalTime.now();
        return String.format("Task duration was "
                + randomSleepTime + " ms, execution finished at "
                + localTime);
    }
}
