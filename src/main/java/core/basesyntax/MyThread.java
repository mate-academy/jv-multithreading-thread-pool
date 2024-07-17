package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = ThreadLocalRandom.current().nextInt(100, 501);
        Thread.sleep(taskDuration);
        LocalTime finishTime = LocalTime.now();

        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, finishTime);
    }
}
