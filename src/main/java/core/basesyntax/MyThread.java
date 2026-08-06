package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final int taskId;

    public MyThread(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int duration = random.nextInt(1000) + 100;
        Thread.sleep(duration);
        LocalTime finishTime = LocalTime.now();
        return String.format("Task %d duration was %d ms, execution finished at %s",
                taskId, duration, finishTime);
    }
}
