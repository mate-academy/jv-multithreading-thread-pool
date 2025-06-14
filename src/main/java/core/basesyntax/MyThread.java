package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random rand = new Random();

    @Override
    public String call() throws InterruptedException {
        int n = (rand.nextInt(6) + 1) * 100;
        Thread.sleep(n);
        return String.format("Task duration was %d ms, execution finished at %s",
                n, LocalTime.now());
    }
}
