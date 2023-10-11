package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();
    private static final int min = 100;
    private static final int max = 999;
    @Override
    public String call() throws InterruptedException {
        int duration = random.nextInt((max - min + 1) + min);
        return String.format(
                "Task duration was %d ms, execution finished at %s",
                duration,
                LocalTime.now()
        );
    }
}
