package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        return "Task duration was " + (System.currentTimeMillis() - currentTimeMillis)
                + " ms, execution finished at " + LocalTime.now();
    }
}
