package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = new Random().nextInt(6000);
        String message = "Task duration was " + taskDuration + ", execution finished at "
                + LocalTime.now();
        System.out.println(message);
        return message;
    }
}
