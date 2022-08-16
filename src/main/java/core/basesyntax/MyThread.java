package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = new Random().nextInt(300);
        Thread.sleep(taskDuration);
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, LocalTime.now());
    }
}
