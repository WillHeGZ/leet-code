package xyz.gzzh.java.senior.day07;

import org.junit.Test;

import java.util.concurrent.*;

/*
 * 创建线程的四种方式：
 *   1.继承Thread类，重写run方法
 *   2.实现Runnable接口
 *   3.实现Callable接口
 *   4.通过线程池创建，Executors.newFixedThreadPool(10);
 *
 * 备注，FutureTask，接受Runnable和Callable
 *
 * */

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

class MyThread1 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                sum += i;
            }
        }

        return sum;
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("通过继承Thread类，重写run方法，创建线程的方式");
    }
}

public class ThreadPoolTest {
    @Test
    public void threadPool() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        service.setCorePoolSize(4);

        Future<?> future = service.submit(new MyThread());

        TimeUnit.SECONDS.sleep(3);
        System.out.println();

        FutureTask futureTask = (FutureTask) service.submit(new MyThread1());
        System.out.println(futureTask.get());

        service.shutdown();

    }

    @Test
    public void callableTest() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread1());
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println(o);
    }

    @Test
    public void test1() {
        var myThread2 = new MyThread2();

        myThread2.start();

        System.out.println("结束");
    }
}
