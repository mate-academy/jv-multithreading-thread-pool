package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int NUMBER_OF_THREADS = 20;
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        // write your code here
        ExecutorService service = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Future<String> future = service.submit(new MyThread());
            futures.add(future);
        }
        service.shutdown();
        for (var future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Something went wrong", e);
            }
        }
    }
}
