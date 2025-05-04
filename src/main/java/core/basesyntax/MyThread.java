package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        return "Task duration was " + random.nextInt(5) * 100
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
