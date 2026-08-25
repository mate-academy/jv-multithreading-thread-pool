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
    private static final int CALLABLE_COUNT = 20;
    private static final int THREAD_POOL_SIZE = 5;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < CALLABLE_COUNT; i++) {
            MyThread myThread = new MyThread();
            Future<String> future = executorService.submit(myThread);
            futures.add(future);
        }

        for (Future<String> future : futures) {
            logger.info(future.get());
        }

        executorService.shutdown();
    }
}
