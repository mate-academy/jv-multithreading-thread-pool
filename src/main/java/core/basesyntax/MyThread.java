package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int time = new Random().nextInt(500);
        Thread.sleep(time);
        return "Task duration was " + time + " ms, execution finished at " + LocalTime.now();
    }
}
