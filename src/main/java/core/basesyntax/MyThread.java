package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long start = System.nanoTime();
        return String.format("Task duration was %d ms, execution finished at %s",
                System.nanoTime() - start, LocalTime.now());
    }
}
