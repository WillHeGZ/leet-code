package xyz.gzzh.leetcode.learning.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * 1 问题：
 * java.util.ConcurrentModificationException
 *
 * 2.解决
 * new Vector();
 * Collections.synchronizedList(new ArrayList<>());
 * new CopyOnWriteArrayList<>();
 *
 * 3.原理
 *
 *
 * */
public class NotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector();//new ArrayList();

        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        set.add("a");

        Map<String, String> map = new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap<>();
        map.put("a", "c");

        Map<String,String> map1 = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        int temp = 1 << 4;

        System.out.println(temp);

    }
}
