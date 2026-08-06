package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int BOUND = 1000;

    @Override
    public String call() throws InterruptedException {
        Long timeDuration = (long) new Random().nextInt(BOUND);
        Thread.sleep(timeDuration);
        return "Task duration was " + timeDuration + " ms, execution finished at "
                + LocalTime.now();
    }
}
