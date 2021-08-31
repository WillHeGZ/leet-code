package xyz.gzzh.leetcode.learning.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {2, 3, 3, 3, 3, 4, 5, 6, 8, 8};
        List<Integer> list = Arrays.stream(ints).boxed().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());

        int i = binarySearch(list.toArray(new Integer[0]), 1);

        System.out.println(i);
    }

    private static int binarySearch(Integer[] ints, int target) {
        if (ints == null || ints.length == 0) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = ints.length - 1;
        int middleIndex = 0;

        while (leftIndex <= rightIndex) {
            middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (ints[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else if (ints[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                if (middleIndex != 0 && ints[middleIndex - 1] == ints[middleIndex]) {
                    rightIndex = middleIndex - 1;
                } else {
                    return middleIndex;
                }
            }
        }

        return -1;
    }
}
