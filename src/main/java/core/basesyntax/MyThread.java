package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String MESSAGE = "Task duration was %2s ms, execution finished at %2s";

    @Override
    public String call() throws InterruptedException {
        int max = 300;
        int min = 100;
        int duration = (int)(Math.random() * (max - min + 1) + min);
        Thread.sleep(50);
        return String.format(MESSAGE, duration, LocalDateTime.now());
    }
}
