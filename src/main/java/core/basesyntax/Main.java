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
    private static final int N_THREADS_POOL = 5;
    private static final int N_THREADS = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS_POOL);
        List<Callable<String>> taskList = new ArrayList<>();
        for (int i = 0; i < N_THREADS; i++) {
            taskList.add(new MyThread());
        }
        try {
            List<Future<String>> futures = executorService.invokeAll(taskList);
            for (Future<String> future : futures) {
                logger.info(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("Something went wrong...", e);
        }
        executorService.shutdown();
    }
}
