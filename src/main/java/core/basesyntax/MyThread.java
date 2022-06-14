package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        String s = "Task duration was %d ms, execution finished at %s";
        int randomTime = new Random().nextInt(500);
        Thread.sleep(randomTime);
        return String.format(s, randomTime, LocalDateTime.now());
    }
}
