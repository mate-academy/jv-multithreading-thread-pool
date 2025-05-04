package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int min = 100;
        int max = 300;
        int diff = max - min;
        Random random = new Random();
        int num = random.nextInt(diff + 1);
        num += min;
        Thread.sleep(100);
        return String.format("Task duration was %d ms, execution finished at %s",
                num, LocalDateTime.now().toString());
    }
}
