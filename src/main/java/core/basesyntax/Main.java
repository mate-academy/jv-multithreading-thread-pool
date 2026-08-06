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
        List<Future<String>> futures;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> threadList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            threadList.add(new MyThread());
        }
        try {
            futures = executor.invokeAll(threadList);
            executor.shutdown();
            for (Future<String> future : futures) {
                logger.info(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Encountered with exception: ", e);
        }
    }
}
