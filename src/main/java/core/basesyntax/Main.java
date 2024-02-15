package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        Callable<String> callable = new MyThread();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 200; i++) {
            futures.add(executorService.submit(callable));
        }
        executorService.shutdown();
        for (var future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
