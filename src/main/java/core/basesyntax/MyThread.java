package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int ms = new Random().nextInt(400);
        Thread.sleep(ms);
        return String.format("Task duration was %d ms, execution finished at %s",
                ms, LocalTime.now());
    }
}
