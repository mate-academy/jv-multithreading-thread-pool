package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        Callable<String> task = new MyThread();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(task));
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
