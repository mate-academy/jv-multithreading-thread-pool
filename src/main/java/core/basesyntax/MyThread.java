package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws Exception {
        int taskDuration = random.nextInt(500) + 100;
        Thread.sleep(taskDuration);

        LocalTime executionTime = LocalTime.now();
        String result = "Task duration was " + taskDuration + " ms, execution finished at " + executionTime;
        return result;
    }
}
