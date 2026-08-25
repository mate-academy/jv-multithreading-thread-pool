package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int random = ThreadLocalRandom.current().nextInt(0, 1000);
        Thread.sleep(random);
        return "Task duration was " + random + " ms, execution finished at " + LocalTime.now();
    }
}
