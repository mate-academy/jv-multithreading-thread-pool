package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(100);
        int randomDuration = random.nextInt(900);
        return "Task duration was " + randomDuration + ", execution finished at "
                + LocalTime.now();
    }
}
