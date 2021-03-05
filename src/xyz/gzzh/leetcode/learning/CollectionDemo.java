package xyz.gzzh.leetcode.learning;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionDemo {
    static List<String> arrayList = new ArrayList<>();
    static List<String> vectorArrayList = new Vector<>();
    static List<String> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
    static List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    static Set<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        VectorArrayListSafe(vectorArrayList);
    }

    private static void VectorArrayListSafe(List<String> vectorArrayList) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                vectorArrayList.add(UUID.randomUUID().toString());
                System.out.println(vectorArrayList);
            }, "thread name : " + i).start();
        }
    }

    private static void CopyOnWriteArrayListSafe() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                copyOnWriteArrayList.add(UUID.randomUUID().toString());
                System.out.println(copyOnWriteArrayList);
            }, "thread name : " + i).start();
        }
    }

    private static void SynchronizedArrayListSafe() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                synchronizedArrayList.add(UUID.randomUUID().toString());
                System.out.println(synchronizedArrayList);
            }, "thread name : " + i).start();
        }
    }

    private static void arrayListNotSafe() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString());
                System.out.println(arrayList);
            }, "thread name : " + i).start();
        }
    }
}
