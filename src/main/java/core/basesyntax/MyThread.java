package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int duration = random.nextInt(5) * 100 + 100; // 100, 200, 300, 400, 500

        Thread.sleep(duration);

        LocalTime finishTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
        String formattedTime = finishTime.format(formatter);

        return String.format("Task duration was %d ms, execution finished at %s",
                duration, formattedTime);
    }
}
