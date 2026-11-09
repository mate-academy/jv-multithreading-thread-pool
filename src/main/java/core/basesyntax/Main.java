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

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<MyThread> myThreads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyThread myThread = new MyThread();
            myThreads.add(myThread);
        }
        List<Future<String>> futures = executorService.invokeAll(myThreads);
        for (Future<String> future : futures) {
            try {
                String s = future.get();
                logger.info(s);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
