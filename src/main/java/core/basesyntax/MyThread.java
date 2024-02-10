package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {

        int sleepingTime = random.nextInt(500);
        Thread.sleep(random.nextInt(sleepingTime));
        return "Task duration was " + sleepingTime
                + " ms, execution finished at " + LocalTime.now();
    }
}
