package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int sleepPeriod = new Random().nextInt(300);
        Thread.sleep(sleepPeriod);
        return "Task duration was " + sleepPeriod + " ms, execution finished at " + LocalTime.now();
    }
}
