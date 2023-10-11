package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        return "Task duration was " + (new Random().nextInt(5) + 1) * 100
                + " ms, execution finished at " + LocalTime.now();
    }
}
