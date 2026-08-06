package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // write your code here
        List<Callable<String>> taskList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            taskList.add(new MyThread());
        }
        List<Future<String>> futures = new ArrayList<>(executorService.invokeAll(taskList));
        for (Future<String> future : futures) {
            String result = future.get();
            logger.log(Level.INFO, result);
        }
        executorService.shutdown();
    }
}
