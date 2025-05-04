package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int seconds = random.nextInt(201) + 100;
        Thread.sleep(seconds);
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
        String formattedDateTime = time.format(formatter);

        return "Task duration was "
            + seconds
            + " ms, execution finished at "
            + formattedDateTime;
    }
}
