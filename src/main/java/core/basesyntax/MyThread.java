package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        Random random = new Random();
        int millis = random.nextInt(501);
        Thread.sleep(millis);
        return String.format("Task duration was %s ms, execution finished at %s",
              millis, LocalTime.now());
    }
}
