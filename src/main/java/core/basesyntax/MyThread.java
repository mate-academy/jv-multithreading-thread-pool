package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomDuration = new Random().nextInt(500);
        Thread.sleep(randomDuration);
        return "Task duration was " + randomDuration
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
