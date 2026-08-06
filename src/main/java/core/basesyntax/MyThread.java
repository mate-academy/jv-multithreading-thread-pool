package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int random = new Random().nextInt(500);
        Thread.sleep(new Random().nextInt(random));
        return "Task duration was " + random + " ms, execution finished at " + LocalTime.now();
    }
}
