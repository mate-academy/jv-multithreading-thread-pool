package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        StringBuilder builder = new StringBuilder();
        int randomMilliSec = new Random().nextInt(1000);
        Thread.sleep(randomMilliSec);
        builder.append("Task duration was ").append(randomMilliSec).append(" ms")
                .append("execution finished at ").append(LocalDateTime.now());
        return builder.toString();
    }
}
