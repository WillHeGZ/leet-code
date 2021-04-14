package xyz.gzzh.leetcode.application;

/*
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *    输入: s = "abcabcbb"
 *    输出: 3
 *    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 *
 * */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }


    public static int lengthOfLongestSubstring(String s) {
        s = s == null ? "" : s;

        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String headStr = "";
            int count = 0;
            for (int j = i; j < chars.length; j++) {
                if (!headStr.contains(String.valueOf(chars[j]))) {
                    count++;
                    headStr = headStr + chars[j];
                } else {
                    break;
                }
            }

            maxLength = count > maxLength ? count : maxLength;
        }

        return maxLength;
    }
}
