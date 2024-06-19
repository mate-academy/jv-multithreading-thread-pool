package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int randomDuration = random.nextInt(500) + 100;
        Thread.sleep(randomDuration);
        return "Task duration was "
                + randomDuration
                + " execution finished at "
                + LocalDateTime.now();
    }
}
