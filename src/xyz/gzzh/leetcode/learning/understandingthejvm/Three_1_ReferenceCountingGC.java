package xyz.gzzh.leetcode.learning.understandingthejvm;

public class Three_1_ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        Three_1_ReferenceCountingGC objA = new Three_1_ReferenceCountingGC();
        Three_1_ReferenceCountingGC objB = new Three_1_ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
