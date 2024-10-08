package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() {
        int taskDuration = ThreadLocalRandom.current().nextInt(10, 1000);
        LocalTime endTime = LocalTime.now();
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, endTime);
    }
}
