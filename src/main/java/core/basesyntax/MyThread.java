package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int randomTime = random.nextInt(400) + 1;
        return "Task duration was " + randomTime
               + " ms, execution finished at "
               + LocalDateTime.now();
    }
}
