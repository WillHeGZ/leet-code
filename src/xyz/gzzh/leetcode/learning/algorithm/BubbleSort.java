package xyz.gzzh.leetcode.learning.algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = new int[]{2, 3, 1, 5, 4, 78, 34, 22};

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(ints));
    }
}
