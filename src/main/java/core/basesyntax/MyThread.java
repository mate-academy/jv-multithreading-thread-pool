package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int suspendDuration = (new Random().nextInt(5) + 1) * 100;
        Thread.sleep(suspendDuration);
        return String.format("Task duration was %d ms,"
                + " execution finished at %s", suspendDuration, LocalTime.now());
    }
}
