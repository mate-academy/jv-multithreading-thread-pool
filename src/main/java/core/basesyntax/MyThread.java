package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private int duration;

    public MyThread(int duration) {
        this.duration = duration;
    }

    @Override
    public String call() throws InterruptedException {
        LocalTime startTime = LocalTime.now();
        Thread.sleep(duration);
        LocalTime endTime = LocalTime.now();
        return "Task duration was " + duration + " ms, execution finished at " + endTime + ".";
    }
}
