package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = new Random().nextInt(201) + 100;
        Thread.sleep(duration);

        return String.format("Task duration was %d, execution finished at %s",
                duration, LocalTime.now());
    }
}
