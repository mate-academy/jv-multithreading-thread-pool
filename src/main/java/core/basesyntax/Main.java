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

/**
 * Create in main() method an ExecutorService instance with a fixed-sized
 * thread pool for 5 threads. Then add 20 threads of type MyThread to your
 * ExecutorService. Let's add Future objects that we receive to the futures
 * list.
 */

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> task = new MyThread();
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(task));
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException("Some exceptions here", e);
            }
        }
    }
}
