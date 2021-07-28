package xyz.gzzh.leetcode.learning.juc;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread() + " " + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println(Thread.currentThread() + " " + "MAIN");
    }
}
