package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(100);
        Random random = new Random();
        return "Task duration was " + random.nextInt(1000)
                + "ms, execution finished at " + LocalTime.now();
    }
}
