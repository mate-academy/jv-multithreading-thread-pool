package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random;

    public MyThread(Random random) {
        this.random = random;
    }

    @Override
    public String call() throws InterruptedException {
        int sleepingTime = random.nextInt(100) + 100;
        Thread.sleep(sleepingTime);
        String result = "Task duration was " + sleepingTime
                + " ms, execution finished at " + LocalTime.now();
        return result;
    }
}
