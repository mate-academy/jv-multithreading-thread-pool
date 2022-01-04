package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();
        Thread.sleep(5);
        LocalTime end = LocalTime.now();
        return "Task duration was " + (end.getNano() - start.getNano())
                + " ms, execution finished at " + end;
    }
}
