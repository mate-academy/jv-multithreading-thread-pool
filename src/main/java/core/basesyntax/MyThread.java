package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        return String.format("Task duration was %s ms, execution finished at %s",
                random.nextInt(500),
                LocalTime.now());
    }
}
