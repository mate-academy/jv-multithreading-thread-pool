package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int i = ThreadLocalRandom.current().nextInt(100, 501);
        Thread.sleep(i);
        return "Task duration was " + i + ", execution finished at " + LocalTime.now();
    }
}
