package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int duration = 100 + random.nextInt(400);
        Thread.sleep(duration);
        return "Task duration was " + duration + " ms, execution finished at " + LocalTime.now();
    }
}
