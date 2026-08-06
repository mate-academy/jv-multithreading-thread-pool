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
    private static final int SIZE_THREAD_POOL = 5;
    private static final int MAX_SIZE_FUTURES = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(SIZE_THREAD_POOL);
        Callable<String> task = new MyThread();
        while (futures.size() != MAX_SIZE_FUTURES) {
            futures.add(executor.submit(task));
        }
        executor.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Some exception was in encountered!", e);
            }
        }
    }
}
