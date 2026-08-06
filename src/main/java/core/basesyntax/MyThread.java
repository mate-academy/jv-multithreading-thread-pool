package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int taskDuration = (int) (Math.random() * 400) + 100;

        Thread.sleep(taskDuration);

        LocalTime finishTime = LocalTime.now();

        return "Task duration was "
                + taskDuration + " ms, execution finished at " + finishTime;
    }
}
