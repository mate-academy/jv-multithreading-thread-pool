package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int randomExecutionTime = (random.nextInt(9) + 1) * 100;
        Thread.sleep(randomExecutionTime);
        return "Task duration was" + randomExecutionTime
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
