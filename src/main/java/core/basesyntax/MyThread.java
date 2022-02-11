package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int waitTime = random.nextInt(5) * 100 + 100;
        Thread.sleep(waitTime);
        return "Task duration was " + waitTime + " ms, execution finished at " + LocalTime.now();
    }
}
