package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long duration = new Random().nextInt(1000);
        Thread.sleep(duration);
        LocalTime time = LocalTime.now();
        return "Task duration was " + duration + " ms, execution finished at " + time;
    }
}
