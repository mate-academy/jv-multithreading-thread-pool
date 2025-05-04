package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long waitTime = (long) (Math.random() * 5) * 100 + 100;
        Thread.sleep(waitTime);
        return "Task duration was "
                + waitTime
                + "ms, execution finished at "
                + LocalDateTime.now();
    }
}
