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
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int NUMBER_OF_THREADS = 5;
    private static final ExecutorService executorService = Executors
            .newFixedThreadPool(NUMBER_OF_THREADS);
    private static final MyThread callable = new MyThread();

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();

        try {
            for (int i = 0; i < 20; i++) {
                Future<String> future = executorService.submit(callable);
                futures.add(future);
                logger.log(Level.INFO, future.get());
            }

            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
