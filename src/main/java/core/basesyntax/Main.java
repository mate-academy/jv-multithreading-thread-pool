package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int NUMBER_OF_TASKS = 20;
    private static final int MAXIMUM_TIME_TO_SLEEP = 500;
    private static final Random random = new Random();
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            Future<String> future = executorService
                    .submit(new MyThread(random.nextInt(MAXIMUM_TIME_TO_SLEEP)));
            futures.add(future);
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Something went wrong", e);
            }
        }
    }
}
