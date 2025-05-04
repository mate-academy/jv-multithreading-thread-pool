package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int workingTime = new Random().nextInt(5) * 100;
        Thread.sleep(100);
        return "Task duration was " + 100
                                    + " ms, execution finished at "
                                    + LocalDateTime.now();
    }
}
