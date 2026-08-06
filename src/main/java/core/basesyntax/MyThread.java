package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int pause = new Random().nextInt(500);
        Thread.sleep(pause);
        return "Task duration was " + pause + "ms, execution finished at " + LocalTime.now();
    }
}
