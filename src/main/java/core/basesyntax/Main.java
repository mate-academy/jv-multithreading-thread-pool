package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final int FIXED_THREAD_POOL_SIZE = 5;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(FIXED_THREAD_POOL_SIZE);

        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(new MyThread()));
        }

        executorService.shutdown();

        futures.forEach(future -> {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException ex) {
                logger.error("Error occurred: ", ex);
            }
        });
    }
}
