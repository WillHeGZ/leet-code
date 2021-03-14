package xyz.gzzh.leetcode.learning;

import java.util.Random;

/*
* 1
* -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC       (DefNew+Tenured)
*
* 2
*                                                                -XX:UseParNewGC        (parNew+Tenured)
*
* 3
*                                                                -XX:UseParallelGC      (PSYoungGen+ParOldGen)
*
* 4
*                                                                -XX:UseParallelOldGC   (PSYoungGen+ParOldGen)
*                                                                                       (PSYoungGen+ParOldGen)
*
*
*
*
*
* */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("****************************************GCDemo Hello*************************");

        try {
            String str = "GC Demo";

            while (true) {
                str += str + new Random().nextInt(777777) + new Random().nextInt(888888888);
                str.intern();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
