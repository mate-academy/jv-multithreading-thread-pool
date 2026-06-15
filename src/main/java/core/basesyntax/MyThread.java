package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDur = ThreadLocalRandom.current().nextInt(100, 500);
        Thread.sleep(taskDur);
        return String.format("Task duration was %s ms, execution finished at %s", taskDur, LocalTime.now());
    }
}
