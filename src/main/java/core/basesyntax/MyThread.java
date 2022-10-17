package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final int duration;

    public MyThread(int duration) {
        this.duration = duration;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(duration);
        return "Task duration was " + duration + " ms, execution finished at "
                + LocalDateTime.now();
    }
}
