package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int durationTime = new Random().nextInt(200);
        Thread.sleep(durationTime);
        return "Task duration was " + new Random().nextInt(200)
                + " ms, execution finished at " + LocalTime.now();
    }
}
