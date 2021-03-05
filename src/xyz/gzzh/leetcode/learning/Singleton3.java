package xyz.gzzh.leetcode.learning;

public class Singleton3 {
    public static final Singleton3 SINGLETON_3;

    static {
        SINGLETON_3 = new Singleton3();
    }

    private Singleton3() {
    }
}
