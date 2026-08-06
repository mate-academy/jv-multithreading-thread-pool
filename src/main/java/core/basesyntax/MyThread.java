package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() {
        int duration = random.nextInt(901) + 100; // from 100ms to 1000ms
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        LocalTime finishTime = LocalTime.now();
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, finishTime);
    }

}
