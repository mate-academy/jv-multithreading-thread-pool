package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
    private static final String[] AVAILABLE_TIME_OF_EXECUTIONS =
            new String[]{"100", "200", "300", "400", "500"};

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(10);
        return String.format(
                "Task duration was %s ms, execution finished at %s",
                AVAILABLE_TIME_OF_EXECUTIONS[new Random().nextInt(5)],
                LocalTime.now().format(FORMATTER));
    }
}
