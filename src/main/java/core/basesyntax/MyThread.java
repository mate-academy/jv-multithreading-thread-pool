package core.basesyntax;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new SecureRandom();

    @Override
    public String call() throws InterruptedException {
        int duration = random.nextInt(1000);
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, LocalTime.now());
    }
}
