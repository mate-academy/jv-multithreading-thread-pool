package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String MESSAGE = "Task duration was %d ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        int suspendTime = new Random().nextInt(200);
        return String.format(MESSAGE, suspendTime, LocalTime.now());
    }
}
