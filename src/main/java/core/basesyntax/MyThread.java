package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int timeDuration = random.nextInt(1000);
        Thread.sleep(timeDuration);
        return "Task duration was " + timeDuration + " ms, execution finished at "
                + LocalTime.now();
    }
}
