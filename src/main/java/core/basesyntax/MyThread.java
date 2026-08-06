package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int random = new Random().nextInt(400);
        Thread.sleep(random);
        return "Task duration was " + random + " ms, execution was finished at "
                + LocalTime.now();
    }
}
