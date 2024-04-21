package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long sleepTime = 100L * (new Random().nextInt(4) + 1);
        Thread.sleep(sleepTime);
        return "Task duration was " + sleepTime + " ms, execution finished at " + LocalTime.now();
    }
}
