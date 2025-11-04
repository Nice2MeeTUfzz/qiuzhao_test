package TME实习;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadExample {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "music-recommend-worker-" + threadNumber.getAndIncrement());
                t.setDaemon(false);
                return t;
            }

            private final AtomicInteger threadNumber = new AtomicInteger(1);

        };

        ExecutorService executor = new ThreadPoolExecutor(
                2,
                4,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100),
                namedThreadFactory
        );

        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            executor.submit(()->{
                System.out.println("Task " + taskId + " running on thread: " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
