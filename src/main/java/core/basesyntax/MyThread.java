package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = (new Random().nextInt(5) + 1) * 100;
        Thread.sleep(duration);
        return "Task duration was " + duration + "ms, execution finished at "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss:SSSSSS"));
    }
}
