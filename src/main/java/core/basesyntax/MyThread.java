package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(300L);
        long end = System.currentTimeMillis();

        return String.format("Task duration was %d ms, execution finished at %s",
                end - start, LocalDateTime.now());
    }
}
