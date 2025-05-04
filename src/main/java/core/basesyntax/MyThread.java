package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MAX_DURATION = 500;

    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = random.nextInt(MAX_DURATION);
        Thread.sleep(taskDuration);
        LocalTime finishTime = LocalTime.now();
        return "Task duration was " + taskDuration + " ms, "
                + "execution finished at " + finishTime;
    }
}
