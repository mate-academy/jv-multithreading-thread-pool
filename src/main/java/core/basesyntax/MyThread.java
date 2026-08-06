package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int suspendTime = new Random().nextInt(300);
        Thread.sleep(suspendTime);
        return String.format("Task duration was %d ms, execution finished at %s",
                suspendTime, LocalTime.now().toString());
    }
}
