package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomTime = new Random().nextInt(600);
        Thread.sleep(randomTime);
        String result = "Task duration was "
                + randomTime + " ms, execution finished at "
                + LocalTime.now();
        return result;
    }
}
