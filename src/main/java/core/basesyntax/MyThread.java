package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = random.nextInt(500) + 100;
        Thread.sleep(taskDuration);
        return String.format("Task duration was %dms, execution finished at %s",
                taskDuration, LocalTime.now());
    }
}
