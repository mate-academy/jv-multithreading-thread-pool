package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 5) * 100;
        Thread.sleep(randomNumber);
        return "Task duration was "
                + randomNumber + " ms, execution finished at "
                + LocalTime.now();
    }
}
