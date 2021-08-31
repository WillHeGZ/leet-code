package xyz.gzzh.leetcode.test3;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;

public class TestIO {
    public static void main(String[] args) throws IOException {
        File file = new File("datas/word.txt");

        Reader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        Collection collection = new ArrayList();
        Map map = new Hashtable();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("123","123");

        System.out.println("***********************");

        InputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        byte[] buffer = new byte[1024];
        int readCount = 0;
        while ((readCount = bufferedInputStream.read(buffer)) != -1){
            String chunk = new String(buffer,0,readCount);
            System.out.println(chunk);
        }

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("");

        List list = new ArrayList();
        list.add("");

        Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);
        new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10));

        AtomicLong atomicLong = new AtomicLong();
        atomicLong.addAndGet(1L);

        Condition condition;
    }

    private synchronized void method2(){}
}
