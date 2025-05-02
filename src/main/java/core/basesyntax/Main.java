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
    private static final int NUMBER_OF_TREADS = 5;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_TREADS);
        Callable<String> task = new MyThread();
        for (int i = 0; i < 20; i++) {
            futures.add(executor.submit(task));
        }
        executor.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
