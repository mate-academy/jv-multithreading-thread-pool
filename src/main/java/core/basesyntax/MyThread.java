package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = random.nextInt(401) + 100;
        try {
            Thread.sleep(taskDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Task interrupted";
        }
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration,
                LocalDateTime.now());
    }
}
