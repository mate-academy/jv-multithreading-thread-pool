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
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyThread myThread = new MyThread();
        for (int i = 0; i < 20; i++) {
            Future<String> future = executorService.submit(myThread);
            futures.add(future);
        }
        executorService.shutdown();

        futures.forEach(future -> {
                    try {
                        logger.info(future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
