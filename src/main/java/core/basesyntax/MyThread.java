package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() {
        int durationMultiplier = random.nextInt(5) + 1;
        int duration = durationMultiplier * 100;
        return String.format("Task duration was %d ms, execution finished at %s", duration,
                LocalTime.now());

    }
}
