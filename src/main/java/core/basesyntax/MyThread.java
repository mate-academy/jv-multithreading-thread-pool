package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int sleep = new Random().nextInt(5) * 100;
        Thread.sleep(sleep);
        return "Task duration was " + sleep
                + " ms, execution finished at " + LocalTime.now();
    }
}
