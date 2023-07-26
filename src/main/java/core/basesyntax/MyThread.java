package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int suspend = new Random().nextInt(500);
        Thread.sleep(suspend);
        return "Task duration was: " + suspend + "ms, execution finished at " + LocalDateTime.now();
    }
}
