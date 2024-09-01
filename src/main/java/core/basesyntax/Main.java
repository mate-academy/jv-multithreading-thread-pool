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
            Future<String> future = executorService.submit(myThread);
            futures.add(future);
        }

        for (Future<String> future : futures) {
            try {
                String value = future.get();
                System.out.println(value);
            } catch (InterruptedException | ExecutionException e) {
                logger.error("An error occurred while executing the task.", e);
            }
        }
        executorService.shutdown();
    }
}
