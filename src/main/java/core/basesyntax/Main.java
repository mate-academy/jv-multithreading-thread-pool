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
        List<Future<String>> futures = new ArrayList<>();
        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            callables.add(new MyThread());
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            futures = executorService.invokeAll(callables);
            Thread.sleep(100);
            for (var future : futures) {
                logger.info(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
