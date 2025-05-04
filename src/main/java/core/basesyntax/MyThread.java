package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int num = new Random().nextInt(500);
        return String.format("Task duration was %d ms, execution finished at %s",
                num, LocalDateTime.now());
    }
}
