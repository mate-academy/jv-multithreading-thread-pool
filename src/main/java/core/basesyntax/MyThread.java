package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = 100 + (int)(Math.random() * 401);
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, LocalTime.now());
    }
}
