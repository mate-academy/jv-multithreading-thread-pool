package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        int num = new Random().nextInt(250);
        return String.format("Task duration was %d ms, execution finished at %s",
                num, LocalDateTime.now());
    }
}
