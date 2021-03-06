package xyz.gzzh.leetcode.learning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
* 实现自旋锁，
* 原理，原子引用，底层调用unSafe类的CAS（compareAndSwap）方法，该方法是Native的
* 属于CPU原语，并且保证了原子性
*
* */
public class SpinLockDemo {
    static class MyLock {

        AtomicReference<Thread> atomicReference = new AtomicReference();

        public void lock() {
            Thread thread = Thread.currentThread();
            while (!atomicReference.compareAndSet(null, thread)) {

            }

            System.out.println(thread.getName() + "\t获取锁成功");
        }

        public void unlock() {
            Thread thread = Thread.currentThread();
            atomicReference.compareAndSet(thread, null);
            System.out.println(thread.getName() + "\t释放锁成功");
        }
    }

    public static void main(String[] args) {
        MyLock lock = new MyLock();

        new Thread(() -> {
            try {
                lock.lock();
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "a").start();

        new Thread(() -> {
            try {
                lock.lock();
            } finally {
                lock.unlock();
            }
        }, "b").start();
    }
}
