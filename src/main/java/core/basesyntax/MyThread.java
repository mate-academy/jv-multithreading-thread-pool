package core.basesyntax;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random;

    public MyThread(Random random) {
        this.random = random;
    }

    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(random.nextInt(1000));
        LocalTime end = LocalTime.now();
        return "Task duration was " + Duration.between(start, end).toMillis() + " ms, execution finished at " + end;
    }
}
