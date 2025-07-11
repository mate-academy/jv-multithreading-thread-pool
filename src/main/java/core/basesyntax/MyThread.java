package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long time = ThreadLocalRandom.current().nextLong(100, 500);
        Thread.sleep(time);
        return "Task duration was " + time + " ms, execution finished at " + LocalTime.now();
    }
}
