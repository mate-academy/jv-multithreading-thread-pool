package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int sleepTime = random.nextInt(500);
        Thread.sleep(sleepTime);
        return "Task duration was " + sleepTime + " ms, execution finished at " + LocalTime.now();
    }
}
