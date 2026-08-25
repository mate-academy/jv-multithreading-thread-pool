package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        for (int i = 0; i < 20; i++) {
            Callable<String> callable = new MyThread();
            futures.add(executorService.submit(callable));
        }

        executorService.shutdown();

        for (Future<String> future: futures) {
            try {
                String message = future.get();
                logger.log(Level.INFO, message);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
