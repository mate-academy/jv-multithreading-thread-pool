package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = random.nextInt(500) + 100;
        Thread.sleep(taskDuration);
        LocalTime executionTime = LocalTime.now();
        return "Task duration was " + taskDuration + " ms, execution finished at " + executionTime;
    }

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        List<Future<String>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            Future<String> future = executorService.submit(new MyThread());
            futures.add(future);
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (Exception e) {
                logger.error("Error retrieving result from Future", e);
            }
        }
    }
}

