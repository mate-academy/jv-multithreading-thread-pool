package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random;

    @Override
    public String call() throws InterruptedException {
        random = new Random();
        int sleepTime = (random.nextInt(10) + 1) * 100;
        Thread.sleep(sleepTime);
        return String.format(
                "Task duration was %d ms, execution finished at %s",
                sleepTime,
                LocalTime.now()
        );
    }
}
