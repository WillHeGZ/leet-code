package xyz.gzzh.leetcode.learning.jvm;

/*
 *
 * Exception in thread "main" java.lang.StackOverflowError
 * 超出栈深度，Error类型报错
 *
 *
 * */
public class StackOverFlowErrorDemo {
    private static void m1() {
        m1();
    }

    public static void main(String[] args) {
        m1();
    }
}
