package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        System.currentTimeMillis();
        return "Task duration was ms " + System.currentTimeMillis()
                + ", execution finished at " + LocalDateTime.now();
    }
}
