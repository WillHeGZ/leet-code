package xyz.gzzh.leetcode.learning;

import java.util.concurrent.*;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue = new PriorityBlockingQueue<>();
//        blockingQueue = new DelayQueue<String>();
        blockingQueue = new SynchronousQueue<>();
        blockingQueue = new LinkedTransferQueue<>();
        blockingQueue = new LinkedBlockingDeque<>();

        /*
         * 抛出异常
         * add：java.lang.IllegalStateException
         * remove：java.util.NoSuchElementException
         * */
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
//        blockingQueue.add("d");

        //检查队首
        blockingQueue.element();

        blockingQueue.remove();
        blockingQueue.remove("b");
        blockingQueue.remove("c");
//        blockingQueue.remove();

        /*
         * 特殊值
         * offer，未加入成功，返回false
         * poll，未获取成功，返回null
         * */
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        System.out.println(blockingQueue.offer("d"));

        //检查队首
        blockingQueue.peek();

        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        System.out.println(blockingQueue.poll());

        /*
         * 阻塞
         * put，等待容量可用；take，等待有值可取
         * */
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
//        blockingQueue.take();

        /*
         * 超时等待,
         * offer，超时返回false
         * poll，超时返回null
         * */
        blockingQueue.offer("a", 1, TimeUnit.SECONDS);
        blockingQueue.offer("b", 1, TimeUnit.SECONDS);
        blockingQueue.offer("c", 1, TimeUnit.SECONDS);
        System.out.println(blockingQueue.offer("d", 1, TimeUnit.SECONDS));

        blockingQueue.poll(1, TimeUnit.SECONDS);
        blockingQueue.poll(1, TimeUnit.SECONDS);
        blockingQueue.poll(1, TimeUnit.SECONDS);
        System.out.println(blockingQueue.poll(1, TimeUnit.SECONDS));


    }
}
