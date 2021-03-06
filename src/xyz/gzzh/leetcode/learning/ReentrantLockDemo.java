package xyz.gzzh.leetcode.learning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//可重入锁，Synchronized reentrantLock 都属于可重入锁，也是独占锁
public class ReentrantLockDemo {
    static class SynchronizedObject implements Runnable {
        public synchronized void sendSMS() {
            System.out.println(Thread.currentThread().getName() + "\t invoked send SMS");
            sendEMail();
        }

        protected synchronized void sendEMail() {
            System.out.println(Thread.currentThread().getName() + "\tinvoked send E-mail");
        }

        @Override
        public void run() {
            sendSMS();
        }
    }

    static class ReentrantLockObject {
        ReentrantLock reentrantLock = new ReentrantLock();

        public void sendSMS() {
            reentrantLock.lock();
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t invoked send SMS");
                sendEMail();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        }

        protected void sendEMail() {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\tinvoked send E-mail");
            } finally {
                reentrantLock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
/*
        SynchronizedObject object = new SynchronizedObject();

        new Thread(() -> {
            object.sendSMS();
        }, "a").start();
        new Thread(() -> {
            object.sendSMS();
        }, "b").start();
*/
        ReentrantLockObject object = new ReentrantLockObject();

        new Thread(() -> {
            object.sendSMS();
        }, "a").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            object.sendSMS();
        }, "b").start();



    }
}
