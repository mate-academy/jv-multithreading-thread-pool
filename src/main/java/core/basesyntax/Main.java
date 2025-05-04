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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 20; i++) {
            Future<String> newCallableTask = executorService.submit(new MyThread());
            futures.add(newCallableTask);
        }
        for (int h = 0; h < futures.size(); h++) {
            logger.info(futures.get(h).get());
        }
        executorService.shutdown();
    }
}
