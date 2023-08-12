package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = new Random().nextInt(400) + 100;
        Thread.sleep(taskDuration);
        return "Task duration was " + taskDuration
                + " ms, execution finished at " + LocalTime.now();
    }
}
