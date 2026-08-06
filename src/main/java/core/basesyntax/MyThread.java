package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long start = System.nanoTime();
        long end = System.nanoTime();
        return "Task duration was " + (end - start)
                + " ms, execution finished at " + LocalTime.now();
    }
}
