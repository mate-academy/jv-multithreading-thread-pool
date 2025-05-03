package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Future<String>> futures = new ArrayList<>();
        Callable<String> callable = new MyThread();

        try {
            for (int i = 0; i < 20; i++) {
                Future<String> future = executorService.submit(callable);
                futures.add(future);
            }

            for (Future<String> future : futures) {
                logger.info(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            logger.error("Error occurred during task execution.", e);
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }
}
