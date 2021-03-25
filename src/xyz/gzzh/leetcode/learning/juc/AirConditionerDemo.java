package xyz.gzzh.leetcode.learning.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition incrementCondition = lock.newCondition();
    Condition decrementCondition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "获得锁");

            while (number != 0) {
                incrementCondition.await();
            }
            System.out.println(number);
            number++;
            decrementCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "获得锁");
            while (number != 1) {
                decrementCondition.await();
            }
            System.out.println(number);
            number--;
            incrementCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class AirConditionerDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                airConditioner.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                airConditioner.decrement();
            }
        }, "C").start();
    }
}
