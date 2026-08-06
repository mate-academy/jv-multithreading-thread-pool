package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        return "Task duration was "
                + (System.currentTimeMillis() - start)
                + " ms , execution finished"
                + " at " + LocalDateTime.now();
    }
}
