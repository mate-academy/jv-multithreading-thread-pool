package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int executionTime = new Random().nextInt(1000);
        Thread.sleep(executionTime);
        return String.format("Task duration was %d ms, execution finished at "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss.SSSSSS")),
                executionTime);
    }
}
