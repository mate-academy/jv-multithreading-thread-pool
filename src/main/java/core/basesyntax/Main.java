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

    public static void main(String[] args) {
        List<Callable<String>> callables = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            callables.add(new MyThread());
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            List<Future<String>> futures = executor.invokeAll(callables);

            futures.forEach(future -> {
                try {
                    logger.info(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Error occurred while executing task: ", e);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
