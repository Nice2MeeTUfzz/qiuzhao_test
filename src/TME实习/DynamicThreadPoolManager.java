package TME实习;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class DynamicThreadPoolManager {

    // 全局线程池注册表：name -> DynamicThreadPool
    private static final Map<String, DynamicThreadPool> POOL_REGISTRY = new ConcurrentHashMap<>();

    // 自定义线程池包装类，支持动态调整
    public static class DynamicThreadPool extends ThreadPoolExecutor {
        private final String poolName;
        private final AtomicInteger rejectedCount = new AtomicInteger(0);

        public DynamicThreadPool(
                int corePoolSize,
                int maximumPoolSize,
                long keepAliveTime,
                TimeUnit unit,
                BlockingQueue<Runnable> workQueue,
                ThreadFactory threadFactory,
                RejectedExecutionHandler handler,
                String poolName) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
            this.poolName = poolName;
        }

        @Override
        public void execute(Runnable command) {
            try {
                super.execute(command);
            } catch (RejectedExecutionException e) {
                rejectedCount.incrementAndGet();
                throw e;
            }
        }

        // 动态调整核心线程数
        public void setCorePoolSize(int corePoolSize) {
            super.setCorePoolSize(corePoolSize);
        }

        // 动态调整最大线程数
        public void setMaximumPoolSize(int maximumPoolSize) {
            super.setMaximumPoolSize(maximumPoolSize);
        }

        // 获取监控指标 // super.getActiveCount()就行，或者直接调用pool.getActiveCount()，父类的这个方法是public的
//        public int getActiveCount() {
//            return this.getActiveCount();
//        }

        public int getQueueSize() {
            return this.getQueue().size();
        }

        public int getRejectedCount() {
            return rejectedCount.get();
        }

        public String getPoolName() {
            return poolName;
        }
    }

    // 创建并注册动态线程池（替代 Executors）
    public static DynamicThreadPool createAndRegister(
            String poolName,
            int corePoolSize,
            int maximumPoolSize,
            int queueCapacity) {

        ThreadFactory threadFactory = r -> {
            AtomicInteger seq = new AtomicInteger(1);
            return new Thread(r, poolName + "-worker-" + seq.getAndIncrement());
        };

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(queueCapacity);

        DynamicThreadPool pool = new DynamicThreadPool(
                corePoolSize,
                maximumPoolSize,
                60L, TimeUnit.SECONDS,
                queue,
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy(), // 或自定义策略
                poolName
        );

        POOL_REGISTRY.put(poolName, pool);
        return pool;
    }

    // 根据名称获取线程池（供配置中心回调使用）
    public static DynamicThreadPool getThreadPool(String poolName) {
        return POOL_REGISTRY.get(poolName);
    }

    // 模拟：从配置中心更新线程池参数（实际应监听 Apollo/Nacos）
    public static void updatePoolConfig(String poolName, int newCore, int newMax, int newQueueSize) {
        DynamicThreadPool pool = POOL_REGISTRY.get(poolName);
        if (pool == null) return;

        // 1. 调整队列（注意：不能直接替换队列，这里简化处理）
        // 实际中可使用 ResizableCapacityLinkedBlockIngQueue（需自定义）

        // 2. 调整线程数
        pool.setCorePoolSize(newCore);
        pool.setMaximumPoolSize(newMax);

        System.out.println("✅ 线程池 [" + poolName + "] 配置已更新: core=" + newCore + ", max=" + newMax);
    }

    // 获取所有线程池状态（用于监控暴露）
    public static Map<String, Object> getAllPoolStats() {
        Map<String, Object> stats = new ConcurrentHashMap<>();
        POOL_REGISTRY.forEach((name, pool) -> {
            stats.put(name, Map.of(
                    "active", pool.getActiveCount(),
                    "queue", pool.getQueueSize(),
                    "rejected", pool.getRejectedCount(),
                    "core", pool.getCorePoolSize(),
                    "max", pool.getMaximumPoolSize()
            ));
        });
        return stats;
    }
}

