package xyz.gzzh.leetcode.learning.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        for (int i = 0; i < 4; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    blockingQueue.put(tempInt + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }


    }
}
