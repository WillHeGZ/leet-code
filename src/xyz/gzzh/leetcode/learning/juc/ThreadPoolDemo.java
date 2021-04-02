package xyz.gzzh.leetcode.learning.juc;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool = Executors.newSingleThreadExecutor();
        threadPool = Executors.newCachedThreadPool();
        threadPool = Executors.newScheduledThreadPool(2);
        threadPool = new ThreadPoolExecutor(3,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            for (int i = 0; i < 10; i++) {
                final int tempInt = i;
                /*threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + tempInt);
                });*/

                Future<String> future = threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + tempInt);
                }, "1231123\t" + tempInt);

                if (future.isDone()) {
                    String result = future.get();
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
