package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        int duration = (new Random().nextInt(9) + 1) * 100;
        Thread.sleep(duration);
        LocalTime localTime = LocalTime.now();
        return "Task duration was " + duration + " ms, execution finished at " + localTime;
    }
}
