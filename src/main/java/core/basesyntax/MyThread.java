package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int nextInt = new Random().nextInt(500);
        Thread.sleep(nextInt);
        return String.format("Task duration was %d ms, execution finished at %s",
                nextInt, LocalTime.now());
    }
}
