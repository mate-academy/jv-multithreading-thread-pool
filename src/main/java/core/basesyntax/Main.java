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
    private static final int THREAD_COUNT = 5;
    private static final int TASKS_COUNT = 20;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < TASKS_COUNT; ++i) {
            Future<String> submit = executorService.submit(new MyThread());
            futures.add(submit);
        }

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
