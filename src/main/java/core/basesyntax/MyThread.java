package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String MESSAGE = "Task duration was %d ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        int randomValueForSuspend = new Random().nextInt(5) + 1;
        int timeOfSuspend = randomValueForSuspend * 100;
        Thread.sleep(timeOfSuspend);
        return String.format(MESSAGE, timeOfSuspend, LocalTime.now());
    }
}
