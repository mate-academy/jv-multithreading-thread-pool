package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        StringBuilder output = new StringBuilder();
        output.append("Task duration was ")
                .append(new Random().nextInt(200))
                .append(" ms, ")
                .append("execution finished at ")
                .append(LocalDateTime.now());
        return output.toString();
    }
}
