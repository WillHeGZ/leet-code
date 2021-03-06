package xyz.gzzh.leetcode.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * ReentrantReadWriteLock 可重入读写锁
 * 读写分离，缓存的概念
 * 写，独占锁
 * 读，共享锁
 * 读写，互斥锁
 *
 * */
public class ReadWriteLockDemo {
    static class MyCache {
        private volatile Map<String, Object> cache = new HashMap<>();

        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        public void put(String key, Object value) {
            try {
                reentrantReadWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + "\t获取锁");
                cache.put(key, value);
                System.out.println(Thread.currentThread().getName() + "\t写入key：" + key + "\tvalue：" + value);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
                System.out.println(Thread.currentThread().getName() + "\t释放锁");
            }
        }

        public Object get(String key) {
            try {
                reentrantReadWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + "\t获取锁");
                Object value = cache.get(key);
                System.out.println(Thread.currentThread().getName() + "\t获取key：" + key + "\tvalue：" + value);
                return value;
            } finally {
                reentrantReadWriteLock.readLock().unlock();
                System.out.println(Thread.currentThread().getName() + "\t释放锁");
            }
        }

        public void clear() {
            cache.clear();
        }
    }

    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i < 10; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.put(String.valueOf(tempInt), tempInt + " value");
            }, i + " put thread").start();
        }

        for (int i = 0; i < 10; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.get(tempInt + "");
            }, i + " get thread").start();
        }
    }
}
