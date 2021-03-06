package xyz.gzzh.leetcode.learning;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("second parameter runnable");
        });

        for (int i = 0; i < 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "\t" + tempInt);
                    cyclicBarrier.await();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, i + " thread").start();
        }


        while (cyclicBarrier.getNumberWaiting() != 0) {
            System.out.println("waiting...");
        }
        System.out.println(Thread.currentThread().getName());
    }
}
