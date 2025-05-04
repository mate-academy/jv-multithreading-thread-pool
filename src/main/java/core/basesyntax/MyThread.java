package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = new Random().nextInt(200) + 300;
        return "Task duration was " + duration
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
