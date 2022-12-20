package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        return "Task duration was " + new Random().nextInt(100)
                + ", execution finished at " + LocalTime.now();
    }
}
