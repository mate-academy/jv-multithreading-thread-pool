package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Random random = new Random();
        int threadSleep = random.nextInt(100);
        Thread.sleep(threadSleep);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Task duration was ")
                .append(threadSleep)
                .append(" ms, execution finished at ").append(localDateTime);
        return stringBuilder.toString();
    }
}
