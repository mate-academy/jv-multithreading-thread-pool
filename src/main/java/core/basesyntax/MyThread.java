package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int sleep = random.nextInt(500);
        Thread.sleep(sleep);
        return "Task duration was " + sleep + " ms, execution finished at " + LocalDateTime.now();
    }
}
