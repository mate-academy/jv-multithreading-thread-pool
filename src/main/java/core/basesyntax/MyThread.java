package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int timeout = new Random().nextInt(5);
        Thread.sleep(timeout * 100);
        return "Task duration was " + timeout * 100 + " ms, execution finished at "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss.SSSSSS"));
    }
}
