package xyz.gzzh.leetcode.learning;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionDemo {
    static List<String> arrayList = new ArrayList<>();
    static List<String> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
    static List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    static Set<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        CopyOnWriteArrayListSafe();
        hashSet.add("c");
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
