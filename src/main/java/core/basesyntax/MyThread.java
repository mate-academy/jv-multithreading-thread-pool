package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomSleep = (int) (Math.random() * 100);
        Thread.sleep(randomSleep);
        return String.format("Task duration was %s ms, execution finished at %s",
                randomSleep, LocalTime.now());
    }
}
