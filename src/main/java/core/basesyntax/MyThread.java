package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    public static final int MAX_DURATION = 200;

    @Override
    public String call() throws InterruptedException {
        int duration = new Random().nextInt(MAX_DURATION);
        Thread.sleep(duration);
        return "Task duration was " + duration + " ms, execution finished at " + LocalTime.now();
    }
}
