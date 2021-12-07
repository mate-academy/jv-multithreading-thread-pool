package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private int duration = new Random().nextInt(100);

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(duration);
        return "Task duration was "
                + duration
                + " ms, execution finished at "
                + LocalDateTime.now();
    }
}
