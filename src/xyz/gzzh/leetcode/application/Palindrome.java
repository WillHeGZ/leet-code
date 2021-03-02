package xyz.gzzh.leetcode.application;

//回文数
public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        int result = 0;
        int in = x;
        while (in != 0) {
            int temp = in % 10;
            in = in / 10;

            result = result * 10 + temp;
        }

        if (x == result) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        boolean isPalindrome = palindrome.isPalindrome(121);

        System.out.println(isPalindrome);
    }
}
