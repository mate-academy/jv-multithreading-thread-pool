package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int runTime = random.nextInt(300);
        Thread.sleep(runTime);
        String log = "Task duration was " + runTime + " ms, execution finished at "
                + LocalTime.now();
        return log;
    }
}
