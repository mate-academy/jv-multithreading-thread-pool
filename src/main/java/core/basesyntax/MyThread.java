package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int TASK_DURATION = 200;

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(TASK_DURATION);

        return String.format("Task duration was %s ms,  execution finished at %s",
                TASK_DURATION, LocalTime.now());

    }
}
