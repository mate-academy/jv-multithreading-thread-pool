package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(1000);
        int random = (new Random().nextInt(4) + 1) * 100;
        return "Task duration was " + random + " ms, execution finished at " + LocalTime.now();
    }
}
