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
    private static final Integer NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        // write your code here
        MyThread myThread = new MyThread();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < 20; i++) {
            Future<String> returnResult = executorService.submit(myThread);
            futures.add(returnResult);
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Something went wrong!", e);
            }
        }
    }
}
