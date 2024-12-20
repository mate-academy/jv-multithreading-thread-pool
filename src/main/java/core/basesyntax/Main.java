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

    public static void main(String[] args) {
        List<Callable<String>> threads = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            threads.add(new MyThread());
        }

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);

            List<Future<String>> futures = executorService.invokeAll(threads);

            for (Future<String> future : futures) {
                logger.log(Level.INFO, future.get());
            }

            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
