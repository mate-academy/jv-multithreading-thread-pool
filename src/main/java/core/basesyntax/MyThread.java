package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MAX_DURATION = 501;

    @Override
    public String call() throws InterruptedException {
        int taskDuration = new Random().nextInt(MAX_DURATION);
        Thread.sleep(taskDuration);
        LocalTime executionTime = LocalTime.now();
        return "Task duration was " + taskDuration + " ms, execution finished at " + executionTime;
    }
}
