package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final long DURATION = 200L;

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(DURATION);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
        return "Task duration was " + DURATION + " ms, execution finished at "
                + LocalDateTime.now().format(formatter);
    }
}
