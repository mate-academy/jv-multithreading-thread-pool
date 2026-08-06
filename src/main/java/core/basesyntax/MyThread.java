package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int timeoutMillis = random.nextInt(401) + 100;
        Thread.sleep(timeoutMillis);
        return "Task duration was " + timeoutMillis
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
