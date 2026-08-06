package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int SLEEP_MULTIPLIER_BOUND = 7;

    @Override
    public String call() throws InterruptedException {
        int taskDuration = new Random().nextInt(SLEEP_MULTIPLIER_BOUND) * 100 + 100;
        Thread.sleep(taskDuration);
        System.out.println("Task duration was "
                + taskDuration
                + " ms, execution finished at "
                + LocalTime.now());
        return "Thread " + Thread.currentThread().getName() + " completed the job!";
    }
}
