package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        return String.format("Task duration was %s ms, execution finished at %s",
                random.nextInt(500),
                LocalDateTime.now().toString());
    }
}
