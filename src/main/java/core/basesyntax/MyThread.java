package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random RANDOM = new Random();
    private static final int MAX_SLEEP_AMOUNT = 500;

    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(RANDOM.nextInt(MAX_SLEEP_AMOUNT));
        return String.format("Task duration was %s ms, execution finished at %s",
                System.currentTimeMillis() - start, LocalTime.now());
    }
}
