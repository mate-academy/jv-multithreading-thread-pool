package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = random.nextInt(501) + 100;
        TimeUnit.MILLISECONDS.sleep(taskDuration);
        return "Task duration was "
                + taskDuration
                + " ms, execution finished at "
                + LocalTime.now();
    }
}
