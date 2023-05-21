package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int execTime = random.nextInt(500) + 100;
        Thread.sleep(execTime);
        return "Task execution was " + execTime + " ms, execution finished at " + LocalTime.now();
    }
}
