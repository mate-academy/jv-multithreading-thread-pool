package core.basesyntax;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final SecureRandom random = new SecureRandom();

    @Override
    public String call() throws InterruptedException {
        int sleepingTime = random.nextInt(200);
        Thread.sleep(sleepingTime);
        return "Task duration was " + sleepingTime + " ms, execution finished at "
                + LocalTime.now();
    }
}
