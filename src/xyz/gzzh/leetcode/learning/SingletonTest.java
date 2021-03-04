package xyz.gzzh.leetcode.learning;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.SINGLETON_1;
        Singleton2 singleton2 = Singleton2.SINGLETON_2;

        System.out.println("singleton 1 : " + singleton1);
        System.out.println("singleton 2 : " + singleton2);
    }
}
