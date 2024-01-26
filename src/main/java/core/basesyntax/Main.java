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
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Callable<String> callable = new MyThread();
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Future<String> result = executor.submit(callable);
            futures.add(result);
        }

        for (int i = 0; i < futures.size(); i++) {
            try {
                logger.info(futures.get(i).get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executor.shutdown();
    }
}
