package xyz.gzzh.leetcode.application;

//数字反转
public class Reverse {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int temp = x % 10;
            x = x / 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }

            result = result * 10 + temp;
        }

        return result;
    }


    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int reverseNumber = reverse.reverse(2147483647);

        System.out.println(reverseNumber);
    }
}
