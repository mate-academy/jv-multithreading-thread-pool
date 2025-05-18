package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int duration = 250 + random.nextInt(140);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "The Task was interrupted";
        }
        LocalDateTime finishedTime = LocalDateTime.now();
        return String.format(
                "Task duration was %d ms, execution finished at %s",
                duration, finishedTime
        );
    }
}
