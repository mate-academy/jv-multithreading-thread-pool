package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int sleepTime = (random.nextInt(10) + 1) * 100;
        Thread.sleep(sleepTime);
        return "Task duration was " + sleepTime + " ms, execution finished at "
                + LocalDateTime.now().toLocalTime();
    }
}
