package core.basesyntax;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime startTime = LocalTime.now();
        return "Task duration was "
                + (startTime.until(LocalTime.now(), ChronoUnit.MILLIS))
                + " ms, execution finished at "
                + LocalTime.now();
    }
}
