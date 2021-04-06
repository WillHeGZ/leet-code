package xyz.gzzh.leetcode.application;

public class SearchInsertIndex {
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            if (num == target){
                return i;
            }
            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int target = 3;

        searchInsert(nums,target);
    }
}
