package xyz.gzzh.leetcode.learning.juc;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

//        completableFuture.

        /*Object[] objects = {"0103600199201027010012",
                "Fusion Fitness",
                "已关闭",
                8};

        for (Object object : objects) {
            System.out.println(object);
        }*/

        System.out.println("-------------------------");
        System.out.println(("TJ000002".hashCode() + "000001".hashCode()) + "");
        System.out.println(("TJ000005".hashCode() + "000002".hashCode()) + "");
        System.out.println(("TJ000004".hashCode() + "000003".hashCode()) + "");
        System.out.println(("TJ000003".hashCode() + "000004".hashCode()) + "");
    }
}
