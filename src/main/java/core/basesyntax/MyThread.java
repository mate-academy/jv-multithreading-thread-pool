package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final String MESSAGE = "Task duration was %d00 ms, execution finished at ";
    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");

    @Override
    public String call() throws InterruptedException {
        return String.format(MESSAGE, random.nextInt(RANDOM_BOUND))
                + LocalTime.now().format(FORMAT);
    }
}
