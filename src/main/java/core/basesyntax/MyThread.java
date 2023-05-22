package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = new Random().nextInt(5) * 100 + 100;
        Thread.sleep(duration);
        return String.format("%s Task duration was %s ms, execution finished at %s",
                Thread.currentThread().getName(),
                duration,
                LocalTime.now());

    }
}
