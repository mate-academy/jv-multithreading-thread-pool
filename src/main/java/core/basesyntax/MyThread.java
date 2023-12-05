package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        return String.format("Task duration was %d ms, execution finished at "
                + LocalDateTime.now(), endTime - startTime);
    }
}
