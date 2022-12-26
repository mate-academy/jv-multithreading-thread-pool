package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomMillis = new Random().nextInt(500);
        Thread.sleep(randomMillis);
        return new String(Thread.currentThread().getName() + " The task duration was "
                + randomMillis + " ms, execution finished at " + LocalTime.now());
    }
}
