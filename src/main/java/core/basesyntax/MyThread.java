package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long startTime = System.nanoTime();
        return "Task duration was " + (System.nanoTime() - startTime)
                + " ms, execution finished at " + LocalTime.now();
    }
}
