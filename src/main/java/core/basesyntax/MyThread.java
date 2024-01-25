package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long delay = (long) (Math.random() * 900 + 100);
        Thread.sleep(delay);
        return String.format("Task duration was %d ms, execution finished at %s",
                delay,
                LocalTime.now()
        );
    }
}
