package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = ThreadLocalRandom.current().nextInt(100, 501);
        Thread.sleep(duration);
        LocalTime finishTime = LocalTime.now();
        return "Task duration was " + duration + " ms, execution finished at " + finishTime;
    }
}
