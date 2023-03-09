package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        int taskDuration = new Random().nextInt(500);
        Thread.sleep(taskDuration);
        return String.format("Task duration was %d, execution finished at %s",
                taskDuration, LocalTime.now().toString());
    }
}
