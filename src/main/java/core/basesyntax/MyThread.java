package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int TASK_DURATION_LIMIT = 200;

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(100);
        return "Task duration was " + new Random().nextInt(TASK_DURATION_LIMIT)
                + " ms, execution finished at " + LocalTime.now();
    }
}
