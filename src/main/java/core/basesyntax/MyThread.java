package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int duration = random.nextInt(400);
        LocalDateTime localDateTime = LocalDateTime.now();
        return "Task duration was " + duration + " ms, execution finished at " + localDateTime;
    }
}
