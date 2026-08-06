package core.basesyntax;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random;

    public MyThread() {
        try {
            this.random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Exception during initialization 'Random'.",e);
        }
    }

    @Override
    public String call() throws InterruptedException {
        int durationTime = random.nextInt(200);
        Thread.sleep(durationTime);
        return "Task duration was " + random.nextInt(200)
                + " ms, execution finished at " + LocalTime.now();
    }
}
