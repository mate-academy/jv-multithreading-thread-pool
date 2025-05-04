package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread implements Callable<String> {
    private static final String MESSAGE = "Task duration was %s ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        int sleepTime = new Random().nextInt(500);
        Thread.sleep(sleepTime);
        return String.format(MESSAGE, sleepTime, LocalDateTime.now());
    }
}
