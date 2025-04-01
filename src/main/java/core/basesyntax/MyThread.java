package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {

    public String call() throws InterruptedException {
        Random random = new Random();
        int taskDuration = 100 + random.nextInt(401);

        Thread.sleep(taskDuration);

        LocalTime finishTime = LocalTime.now();
        return "Task duration was " + taskDuration + " ms, execution finished at " + finishTime;
    }
}
