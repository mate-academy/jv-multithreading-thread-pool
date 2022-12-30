package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final int timeToSleep;

    public MyThread(int timeToSleep) {
        this.timeToSleep = timeToSleep;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(timeToSleep);
        return String.format("Task duration was %s ms, execution finished at %s",
                timeToSleep, LocalTime.now().toString());
    }
}
