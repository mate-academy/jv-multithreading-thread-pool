package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int THREADS_AMOUNT = 20;

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            Future<String> future = executorService.submit(new Task());
            futures.add(future);
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            try {
                logger.log(Level.INFO, future.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted", e);
            } catch (ExecutionException e) {
                throw new RuntimeException("Execution failed", e);
            }
        }
    }
}
