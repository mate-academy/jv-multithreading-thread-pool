package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        Random rand = new Random();
        int random = rand.nextInt(5) + 1;
        Thread.sleep(100 * random);
        return String.format(
                "Task duration was %s ms, execution finished at %s",
                100 * random, LocalDateTime.now()
                        .format(DateTimeFormatter
                                .ofPattern("HH:mm:ss.SSS")));
    }
}
