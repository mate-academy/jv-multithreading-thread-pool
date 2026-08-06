package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long duraion = ThreadLocalRandom.current().nextLong(10, 1000);
        Thread.sleep(duraion);
        return "Task duration was " + duraion + " ms, execution finished at " + LocalTime.now();
    }
}
