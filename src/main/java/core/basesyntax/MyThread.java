package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int randomNumber = random.nextInt(5) + 1;
        Thread.sleep(randomNumber * 100);
        return "Task duration was " + randomNumber * 100
                + " ms, execution finished at " + LocalTime.now();
    }
}
