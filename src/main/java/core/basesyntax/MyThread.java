package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = (new Random().nextInt(5) + 1) * 100;
        Thread.sleep(taskDuration);
        Thread.currentThread().interrupt();
        LocalTime now = LocalTime.now();
        return "Task duration was " + taskDuration + " ms, execution finished at " + now;
    }
}
