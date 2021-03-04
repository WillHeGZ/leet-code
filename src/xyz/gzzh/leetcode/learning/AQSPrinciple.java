package xyz.gzzh.leetcode.learning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AQSPrinciple {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread a = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\tcome in one step");
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + "\tcome in two step");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A");
        a.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\tcome in one step");
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\tcome in two step");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\tcome in one step");
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\tcome in two step");
            lock.unlock();
        }, "C").start();

    }
}
