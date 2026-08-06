package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final int taskDuration;

    public MyThread(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(taskDuration);
        LocalTime finishTime = LocalTime.now();
        return String.format(
                "Task duration was %d ms, execution finished at %s", taskDuration, finishTime);
    }
}
