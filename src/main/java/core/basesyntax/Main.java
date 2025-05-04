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

    public static void main(String[] args) {
        // write your code here
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> thread = new MyThread();
        List<Future<String>> futureOut = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futureOut.add(executorService.submit(thread));
        }
        executorService.shutdown();
        for (Future<String> out :
                futureOut) {
            String message;
            try {
                message = out.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            logger.log(Level.INFO, message);
            System.out.println(message);
        }
    }
}
