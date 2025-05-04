package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int TIME_SLEEPING = 5;

    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(TIME_SLEEPING);
        LocalTime end = LocalTime.now();
        return "Task duration was " + (end.getNano() - start.getNano())
                + " ms, execution finished at " + end;
    }
}
