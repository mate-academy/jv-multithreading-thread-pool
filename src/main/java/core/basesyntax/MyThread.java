package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() {
        int taskDuration = 100 + new Random().nextInt(201);

        try {
            Thread.sleep(taskDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        LocalTime finishTime = LocalTime.now();
        return String.format("Task duration was %d ms, " +
                "execution finished at %s", taskDuration, finishTime);
    }
}
