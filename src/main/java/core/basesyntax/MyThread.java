package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(200);
        int sleepMs = ThreadLocalRandom.current().nextInt(200, 500);
        Thread.sleep(sleepMs);
        return "Task duration was " + sleepMs
                + " ms, execution finished at " + LocalTime.now();
    }
}
