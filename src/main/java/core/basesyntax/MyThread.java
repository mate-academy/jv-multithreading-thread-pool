package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int taskDuration = random.nextInt(500) + 100;
        Thread.sleep(taskDuration);
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, LocalTime.now());
    }
}
