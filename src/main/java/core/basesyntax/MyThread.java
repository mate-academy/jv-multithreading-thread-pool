package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000);
        return String.format("Task duration was %d ms, execution finished at %s",
                System.currentTimeMillis() - startTime, LocalTime.now());
    }
}
