package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = ThreadLocalRandom.current().nextInt(100, 501);

        Thread.sleep(taskDuration);

        LocalDateTime localDateTime = LocalDateTime.now();

        return "Task duration was " + taskDuration + " ms, execution finished at " + localDateTime;
    }
}
