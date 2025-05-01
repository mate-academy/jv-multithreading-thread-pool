package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int TASK_DURATION = 200;

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(TASK_DURATION);
        LocalTime finishTime = LocalTime.now();
        return "Task duration was " + TASK_DURATION + " ms, execution finished at " + finishTime;
    }
}
