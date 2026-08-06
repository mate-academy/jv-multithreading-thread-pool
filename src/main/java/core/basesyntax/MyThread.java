package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(100);
        return "Task duration was " + new Random().nextInt(1000)
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
