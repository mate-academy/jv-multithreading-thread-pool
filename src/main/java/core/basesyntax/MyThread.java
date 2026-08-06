package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomNumber = new Random().nextInt(1000);
        Thread.sleep(randomNumber);
        return "Task duration was " + 200
                + " ms, execution finished at " + LocalTime.now();
    }
}
