package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int sleep = new Random().nextInt(400);
        Thread.sleep(sleep);
        return String.format("Task duration was %d ms, execution finished at %s",
                sleep, LocalTime.now());
    }
}
