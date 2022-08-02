package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random;

    public MyThread() {
        this.random = new Random();
    }

    @Override
    public String call() throws InterruptedException {
        int nextInt = random.nextInt(1000);
        Thread.sleep(nextInt);
        return "Task duration was " + nextInt
                + " ms, execution finished at " + LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS"));
    }
}
