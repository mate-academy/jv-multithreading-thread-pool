package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final int duration;

    public MyThread(int duration) {
        this.duration = duration;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(duration);
        LocalTime finishTime = LocalTime.now();
        return String.format(
                "Task duration was %d ms, execution finished at %s",
                duration,
                finishTime
        );
    }
}
