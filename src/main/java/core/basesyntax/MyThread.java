package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(100);

        return "Task duration was "
                + (System.currentTimeMillis() - start)
                + " ms, execution finished at "
                + LocalTime.now();
    }
}
