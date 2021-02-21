package xyz.gzzh.leetcode.application;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        int result = missingNumber(nums);
        System.out.println(result);
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length + 1;
        int max = length - 1;
        int sum = max * length / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }
}
