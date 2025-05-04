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
        List<Future<String>> futures = new ArrayList<>();
        Callable<String> callable = new MyThread();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Future<String> future = fixedThreadPool.submit(callable);
            try {
                logger.log(Level.INFO, future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Couldn't get a value from future", e);
            }
            futures.add(future);
        }
        fixedThreadPool.shutdown();
    }
}
