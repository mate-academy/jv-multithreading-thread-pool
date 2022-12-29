package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        long taskDuration = new Random().nextInt(200);
        Thread.sleep(Math.abs(taskDuration));
        return String.format("Task duration was %d ms,"
                + " execution finished at %s", taskDuration, LocalTime.now());
    }
}
