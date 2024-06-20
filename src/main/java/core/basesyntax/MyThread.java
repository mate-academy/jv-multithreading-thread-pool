package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = (int) Math.round(Math.random() * 1000);
        Thread.sleep(taskDuration);
        LocalTime finishAt = LocalTime.now();
        return String.format("Task duration was %d ms, execution finished at %s", taskDuration, finishAt);
    }
}
