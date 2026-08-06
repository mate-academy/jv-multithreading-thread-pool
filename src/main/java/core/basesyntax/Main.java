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
    private static final int POOL_SIZE = 5;
    private static final int NUMBER_OF_THREADS = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
            Callable<String> callable = new MyThread();
            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                Future<String> future = executorService.submit(callable);
                futures.add(future);
            }

            for (Future<String> future : futures) {
                logger.info(future.get());
            }
            executorService.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
