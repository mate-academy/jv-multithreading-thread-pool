package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt(100 - 1) + 1;
        Thread.sleep(i * 100);
        return "Task duration was " + i + "ms, execution finished at " + LocalDateTime.now();
    }
}
