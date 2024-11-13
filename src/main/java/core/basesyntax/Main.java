package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
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
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        try {
            MyThread task = new MyThread();
            for (int i = 0; i < 20; i++) {
                futures.add(executorService.submit(task));
            }

            for (Future<String> future : futures) {
                String result = future.get();
                logger.info(result);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(String.format("Error occurred during execution: %s", e.getMessage()), e);
        } finally {
            if (!executorService.isShutdown()) {
                executorService.shutdown();
            }
        }
    }
}
