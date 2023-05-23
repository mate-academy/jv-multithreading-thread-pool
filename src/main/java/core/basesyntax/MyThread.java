package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String MESSAGE_FORMAT = "Task duration was %d ms, execution finished at %s";
    @Override
    public String call() throws InterruptedException {
        int sleepTime = new Random().nextInt(500);
        Thread.sleep(sleepTime);
        return String.format(MESSAGE_FORMAT, sleepTime, LocalDateTime.now());
    }
}
