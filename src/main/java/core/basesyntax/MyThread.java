package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = new Random().nextInt(1000);
        Thread.sleep(duration);
        return "task duration was " + duration
                + " ms, execution finished at " + LocalTime.now();
    }
}
