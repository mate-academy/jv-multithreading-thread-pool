package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = new Random().nextInt(1000);
        Thread.sleep(taskDuration);
        return "Task duration was " + taskDuration + " ms, execution finished at "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.nn"));
    }
}
