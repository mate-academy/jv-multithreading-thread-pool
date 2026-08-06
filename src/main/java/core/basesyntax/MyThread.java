package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random;

    {
        random = new Random();
    }

    @Override
    public String call() throws InterruptedException {
        int val = (random.nextInt(5) + 1) * 100;
        Thread.sleep(val);
        return String.format("Task duration was %d ms, execution finished at %s",
                val, LocalTime.now());
    }
}
