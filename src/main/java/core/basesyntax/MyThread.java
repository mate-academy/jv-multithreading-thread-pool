package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        Double x = Math.random();
        Long waiting = (long)(x * 300);
        Thread.sleep(waiting);
        LocalTime now = LocalTime.now();
        return "Task duration was " + waiting + " ms, execution finished at " + now;
    }
}
