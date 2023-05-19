package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int timeSleeping = new Random().nextInt(1000);
        Thread.sleep(timeSleeping);
        return "Task duration was "
                + timeSleeping
                + " ms, execution finished at "
                + LocalDateTime.now();
    }
}
