package xyz.gzzh.leetcode.learning;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * CountDownLatch，倒计时，指定计数个数，减数完成，完成await后操作
 * 底层，AQS，自旋，CAS
 *
 * */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t离开自习室");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }, i + " thread").start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t锁门");
    }
}
