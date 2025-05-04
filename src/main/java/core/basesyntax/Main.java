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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> task = new MyThread();
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(task));
        }

        executorService.shutdown();

        for (Future<String> future: futures) {
            System.out.println(future.get());
            logger.info(future.get());
        }
    }
}
