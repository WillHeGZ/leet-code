package xyz.gzzh.leetcode.learning;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 * Semaphore，信号灯
 * 指定容量，获取一个释放一个
 * 底层，AQS，自旋，CAS
 * */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    System.out.println(tempInt + "\t尝试占有");
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(tempInt + "\t占有成功,并休眠了3秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
