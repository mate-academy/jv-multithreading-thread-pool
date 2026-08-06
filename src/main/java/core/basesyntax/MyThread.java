package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(200);
        return "Task duration was 200ms, execution finished at " + LocalTime.now().toString();
    }
}
