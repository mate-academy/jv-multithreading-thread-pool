package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration;

        Random random = new Random();
        duration = ((100 + random.nextInt(400)) / 100) * 100;
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at "
                + LocalTime.now(), duration);

    }
}
