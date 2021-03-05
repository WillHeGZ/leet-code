package xyz.gzzh.leetcode.learning;

public class Test {
    public static void main(String[] args) {
        int i = 1;
        //i++ 返回原值；++i 返回加1后的值
        i = i++; // i = 1
        int j = i++; //j = 1  i = 2
        int k = i + ++i * i++; // 2 + 3 * 3   i = 4 k = 11

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }
}
