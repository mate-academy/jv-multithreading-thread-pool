package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = ThreadLocalRandom.current().nextInt(1, 10) * 100;
        Thread.sleep(duration);
        return String.format("Task duration was %s ms, execution finished at %s",
                duration, LocalTime.now());
    }
}
