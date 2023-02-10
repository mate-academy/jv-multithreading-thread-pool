package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> myThread = new MyThread();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(myThread));
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
