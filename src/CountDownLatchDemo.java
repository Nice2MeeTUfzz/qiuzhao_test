import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 初始化：3个任务完成后唤醒主线程
        CountDownLatch latch = new CountDownLatch(3);

        // 启动3个子线程（3个任务）
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 完成任务");
                latch.countDown(); // 任务完成，计数器减1
            }, "子线程" + i).start();
        }

        System.out.println("主线程等待所有子线程完成...");
        latch.await(); // 主线程阻塞，直到state=0
        System.out.println("所有子线程完成，主线程继续执行");
    }
}