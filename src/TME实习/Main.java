package TME实习;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 创建并注册线程池
        var executor = DynamicThreadPoolManager.createAndRegister(
                "music-recommend", 2, 4, 100
        );

        // 提交任务
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " on " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (Exception e) {}
            });
        }

        // 模拟：动态调整配置（实际由配置中心触发）
        Thread.sleep(2000);
        DynamicThreadPoolManager.updatePoolConfig("music-recommend", 3, 6, 200);

        // 打印监控指标
        System.out.println(DynamicThreadPoolManager.getAllPoolStats());
    }
}
