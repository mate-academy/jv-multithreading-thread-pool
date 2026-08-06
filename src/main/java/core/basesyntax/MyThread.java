package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int BEGIN_NUMBER = 30;
    private static final int BOUND_NUMBER = 250;

    @Override
    public String call() throws InterruptedException {
        int durationTime = new Random().nextInt(BOUND_NUMBER) + BEGIN_NUMBER;
        Thread.sleep(durationTime);
        return "Task duration was " + durationTime + " ms, execution finished at "
                + LocalTime.now();
    }
}
