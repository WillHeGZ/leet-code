package xyz.gzzh.leetcode.learning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicInteger atomicInteger = new AtomicInteger(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);


    public static void main(String[] args) {
        System.out.println("==================================ABA例子======================================");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicReference.compareAndSet(100, 2019);
            System.out.println(Thread.currentThread().getName() + "\t" + b + "\t" + atomicReference.get());
        }, "t2").start();

        new Thread(() -> {
            atomicInteger.compareAndSet(100, 101);
            atomicInteger.compareAndSet(101, 100);
        }, "t3");

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicInteger.compareAndSet(100, 2019);
            System.out.println(Thread.currentThread().getName() + "\t" + b + "\t" + atomicInteger.get());
        }, "t4").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==================================ABA解决方法======================================");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            Integer reference = atomicStampedReference.getReference();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = atomicStampedReference.compareAndSet(reference, reference + 1, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t" + b + "\t now stamp : " + atomicStampedReference.getStamp() + "\t now reference : " + atomicStampedReference.getReference());
            boolean b1 = atomicStampedReference.compareAndSet(reference + 1, reference, stamp + 1, stamp + 1 + 1);
            System.out.println(Thread.currentThread().getName() + "\t" + b1 + "\t now stamp : " + atomicStampedReference.getStamp() + "\t now reference : " + atomicStampedReference.getReference());
        }, "t5").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            Integer reference = atomicStampedReference.getReference();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = atomicStampedReference.compareAndSet(reference, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t" + b + "\t now stamp : " + atomicStampedReference.getStamp() + "\t now reference : " + atomicStampedReference.getReference());
        }, "t6").start();
    }
}
