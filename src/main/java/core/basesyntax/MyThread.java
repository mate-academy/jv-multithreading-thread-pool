package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        int randomDuration = new Random().nextInt(1000);
        Thread.sleep(randomDuration);
        LocalTime time = LocalTime.now();
        return "Task duration was " + randomDuration + " ms, execution finished at " + time;
    }
}
