package xyz.gzzh.leetcode.learning.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int i = binarySearch(ints, 9);
        System.out.println(i);
    }

    private static int binarySearch(int[] ints, int target) {
        int leftIndex = 0;
        int rightIndex = ints.length - 1;

        while (leftIndex <= rightIndex) {
            int middle = leftIndex + (rightIndex - leftIndex) / 2;

            if (ints[middle] < target) {
                leftIndex = middle + 1;
            } else if (ints[middle] > target) {
                rightIndex = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
