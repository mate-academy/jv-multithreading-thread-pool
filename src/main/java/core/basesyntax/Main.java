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

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<Future<String>>();
        Callable<String> callable = new MyThread();
        for (int i = 0; i < 20; i++) {
            Future<String> future = executor.submit(callable);
            futures.add(future);
        }
        for (Future<String> fut : futures) {
            try {
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
