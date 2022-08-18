package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int LOWER_NUMBER = 100;
    private static final int UPPER_NUMBER = 500;

    @Override
    public String call() throws InterruptedException {
        int random = (int)((Math.random() * (UPPER_NUMBER - LOWER_NUMBER + 1)));
        int duration = random - random % LOWER_NUMBER + LOWER_NUMBER;
        Thread.sleep(duration);
        return "Task duration was: " + duration + " ms, execution finished at "
                + LocalTime.now().toString();
    }
}
