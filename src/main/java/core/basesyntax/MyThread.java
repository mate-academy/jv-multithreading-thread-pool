package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int taskDuration = 100 + random.nextInt(401);

        TimeUnit.MILLISECONDS.sleep(taskDuration);

        LocalTime endTime = LocalTime.now();

        return String.format("Task duration was %d ms, execution finished at %s", taskDuration, endTime);
    }
}
