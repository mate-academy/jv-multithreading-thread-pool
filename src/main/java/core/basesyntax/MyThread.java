package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
       int random = new Random().nextInt(6) * 100;
       Thread.sleep(random);
        return String.format("Task duration was %d ms, execution finished at %s",
                random, LocalDateTime.now());
    }
}
