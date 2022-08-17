package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        return "Task duration was " + random.nextInt(500) + " ms, execution finished at "
                + LocalTime.now();
    }
}
