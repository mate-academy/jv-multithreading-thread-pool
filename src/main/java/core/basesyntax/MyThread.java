package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String CALLABLE_MESSAGE =
            "Task duration was %d ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        int sleepTime = (new Random().nextInt(8) + 1) * 100;
        Thread.sleep(sleepTime);
        return String.format(CALLABLE_MESSAGE, sleepTime, LocalTime.now());
    }
}
