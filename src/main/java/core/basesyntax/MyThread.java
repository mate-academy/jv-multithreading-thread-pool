package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int millis = random.nextInt(1000);
        Thread.sleep(millis);
        return String.format("Task duration was %d ms, execution finished at %s",
                millis, LocalTime.now());
    }
}
