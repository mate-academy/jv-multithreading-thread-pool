package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = random.nextInt(200);
        Thread.sleep(taskDuration);
        return String.format("Task duration was %s ms, finished at %s",
                taskDuration, LocalDateTime.now());
    }
}
