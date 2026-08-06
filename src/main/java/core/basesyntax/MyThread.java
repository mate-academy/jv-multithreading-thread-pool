package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int randomInteger = random.nextInt(1000);
        Thread.sleep(randomInteger);

        StringBuilder sb = new StringBuilder();
        sb
                .append("Task duration was ")
                .append(randomInteger)
                .append(" ms, execution finished at ")
                .append(LocalTime.now());
        return sb.toString();
    }
}
