package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int TOP_BOUND = 500;
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int currentMills = random.nextInt(TOP_BOUND);
        Thread.sleep(currentMills);
        StringBuilder builder = new StringBuilder();
        builder.append("Task duration was ")
                .append(currentMills)
                .append(" ms, execution finished at ")
                .append(LocalDateTime.now());
        return builder.toString();
    }
}
