package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int MAX_DURATION = 100;

    @Override
    public String call() throws InterruptedException {
        int duration = new Random().nextInt(MAX_DURATION);
        Thread.sleep(duration);
        return String.format("Task duration was %s ms, "
                + "execution finished at %s", duration, LocalTime.now());
    }
}
