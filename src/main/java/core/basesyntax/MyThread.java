package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long wait = new Random().nextInt(5) * 100L;
        Thread.sleep(wait);
        return "Task duration was " + (System.currentTimeMillis() - startTime)
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
