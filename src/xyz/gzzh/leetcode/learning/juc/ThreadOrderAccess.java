package xyz.gzzh.leetcode.learning.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print() {
        System.out.println(Thread.currentThread().getName() + "\t抢占锁");
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t获得锁");
        try {
            String threadName = Thread.currentThread().getName();
            if ("A".equals(threadName)) {
                while (number != 1) {
                    condition1.await();
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }

                number = 2;
                condition2.signal();
            }else if ("B".equalsIgnoreCase(threadName)){
                while (number != 2) {
                    condition2.await();
                }

                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }

                number = 3;
                condition3.signal();
            }else {
                while (number != 3) {
                    condition3.await();
                }

                for (int i = 0; i < 15; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }

                number = 1;
                condition1.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                shareResource.print();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                shareResource.print();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                shareResource.print();
            }
        }, "B").start();
    }
}
