package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {

        int duration = random.nextInt(6) * 100;
        Thread.sleep(duration);
        return "Task duration was " + duration
                + " ms, execution finished at " + LocalDateTime.now();
    }
}
