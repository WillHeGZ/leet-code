package xyz.gzzh.leetcode.test3;

import javafx.concurrent.Task;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)    //防止虚假唤醒，Condition的await调用一般会放在一个循环判断中
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        PutThread putThread = new PutThread(boundedBuffer);
        TaskThread taskThread = new TaskThread(boundedBuffer);

        putThread.start();
        taskThread.start();

        LockSupport.park();

    }


    static class PutThread extends Thread {
        private BoundedBuffer boundedBuffer;

        public PutThread(BoundedBuffer boundedBuffer) {
            this.boundedBuffer = boundedBuffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    boundedBuffer.put("1");
                    System.out.println("put success");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskThread extends Thread {
        private BoundedBuffer boundedBuffer;

        public TaskThread(BoundedBuffer boundedBuffer) {
            this.boundedBuffer = boundedBuffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String take = (String) boundedBuffer.take();
                    System.out.println("take : " + take);
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
