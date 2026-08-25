package core.basesyntax;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();
        MyThread thread6 = new MyThread();
        MyThread thread7 = new MyThread();
        MyThread thread8 = new MyThread();
        MyThread thread9 = new MyThread();
        MyThread thread10 = new MyThread();
        MyThread thread11 = new MyThread();
        MyThread thread12 = new MyThread();
        MyThread thread13 = new MyThread();
        MyThread thread14 = new MyThread();
        MyThread thread15 = new MyThread();
        MyThread thread16 = new MyThread();
        MyThread thread17 = new MyThread();
        MyThread thread18 = new MyThread();
        MyThread thread19 = new MyThread();
        MyThread thread20 = new MyThread();
        List<MyThread> list = List.of(thread1, thread2, thread3, thread4, thread5,
                thread6, thread7, thread8, thread9, thread10, thread11, thread12, thread13,
                thread14, thread15, thread16, thread17, thread18, thread19, thread20);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Future<String>> futures = executorService.invokeAll(list);
            for (Future<String> future : futures) {
                logger.info(future.get());;
            }
            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
