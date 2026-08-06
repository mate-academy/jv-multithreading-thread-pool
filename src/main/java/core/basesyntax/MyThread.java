package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = new Random().nextInt(300);
        Thread.sleep(taskDuration);
        return "Task duration was "
                + taskDuration + ", execution finished at "
                + LocalDateTime.now();
    }
}
