package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        // write your code here
        long duration = ((long) (Math.random() * 5) + 1) * 100;
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, "
                + "execution finished at %s", duration, LocalTime.now());
    }
}
