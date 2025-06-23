package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int NUBER_OF_THREADS = 5;
    private static final int NUMBER_OF_TASKS = 20;

    public static void main(String[] args) {

        ExecutorService executorService = null;
        List<Future<String>> futures = new ArrayList<>();
        try {
            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                futures.add(executorService.submit(new MyThread()));
            }
            for (Future<String> future : futures) {
                try {
                    String result = future.get();
                    logger.info("Retrieved result: {}", result);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Thread was interrupted while waiting for task completion", e);
                } catch (ExecutionException e) {
                    logger.error("Exception occurred during task execution", e);
                }
            }

        } finally {
            if (executorService != null) {
                executorService.shutdown();
                logger.info("ExecutorService has been shut down.");
            }
        }
    }
}
