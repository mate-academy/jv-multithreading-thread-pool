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
    public static final int nThreads = 5;
    public static final int nMyThreads = 20;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        // write your code here
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        Callable<String> task = new MyThread();
        for (int i = 0; i < nMyThreads; i++) {
            futures.add(executorService.submit(task));
        }
        executorService.shutdown();
        futures.forEach(l -> {
            try {
                logger.info(l.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Can't log info about object: " + l, e);
            }
        });
    }
}
