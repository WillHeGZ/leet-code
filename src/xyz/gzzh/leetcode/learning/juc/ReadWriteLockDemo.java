package xyz.gzzh.leetcode.learning.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String, Object> cacheMap = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public Object put(String key, Object value) throws InterruptedException {
        Lock writeLock = lock.writeLock();
        Boolean lockStatus = false;
        try {
            lockStatus = writeLock.tryLock(3L, TimeUnit.SECONDS);
            if (lockStatus) {
                System.out.println(Thread.currentThread().getName() + "\t写入开始\t" + key);
                cacheMap.put(key, value);
                System.out.println(Thread.currentThread().getName() + "\t写入完成\t" + key);
                return cacheMap.put(key, value);
            } else {
                throw new RuntimeException(Thread.currentThread().getName() + "\tlock failure");
            }
        } catch (InterruptedException e) {
            throw e;
        } finally {
            if (lockStatus) {
                writeLock.unlock();
            }
        }
    }

    public Object get(String key) throws InterruptedException {
        Lock readLock = lock.readLock();
        Boolean lockStatus = false;

        try {
            lockStatus = readLock.tryLock(3L, TimeUnit.SECONDS);
            if (lockStatus) {
                System.out.println(Thread.currentThread().getName() + "\t读取开始\t" + key);
                Object value = cacheMap.get(key);
                System.out.println(Thread.currentThread().getName() + "\t读取完成\t" + value);
                return value;
            } else {
                throw new RuntimeException(Thread.currentThread().getName() + "\tlock failure");
            }
        } catch (InterruptedException e) {
            throw e;
        } finally {
            if (lockStatus) {
                readLock.unlock();
            }
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    cache.put(tempInt + "", tempInt + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    cache.get(tempInt + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
    }

}
