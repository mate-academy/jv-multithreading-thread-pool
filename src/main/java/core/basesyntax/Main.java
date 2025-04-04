package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        // write your code here
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 20; i++) {
                Future<String> future = executorService.submit(new MyThread());
                futures.add(future);
            }
            executorService.shutdown();

            for (Future<String > future: futures){
                String string = future.get();
                System.out.println(string);
            }

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
