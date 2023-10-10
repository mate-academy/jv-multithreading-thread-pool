package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomTaskDuration = ((int) (Math.random() * 10) * 100);
        Thread.sleep(randomTaskDuration);
        return "Task duration was " + randomTaskDuration
                + " ms, execution finished at " + LocalTime.now();
    }
}
