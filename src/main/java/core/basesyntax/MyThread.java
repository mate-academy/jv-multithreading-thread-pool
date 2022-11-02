package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(new Random().nextInt(500));
        long end = System.currentTimeMillis();
        return "Task duration was " + (end - start)
                + "ms, execution finished at "
                + LocalTime.now();
    }
}
