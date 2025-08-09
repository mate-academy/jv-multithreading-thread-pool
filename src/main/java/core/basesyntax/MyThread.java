package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int randomInt = random.nextInt(200);

        Thread.sleep(randomInt);

        return "Task duration was " + randomInt
                + "ms, execution finished at " + LocalTime.now();
    }
}
