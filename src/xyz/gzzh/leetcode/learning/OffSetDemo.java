package xyz.gzzh.leetcode.learning;

public class OffSetDemo {
    public static void main(String[] args) {
        /*
        * 1的二进制     左移3位
        * 0000 0001 -> 0000 1000 -> 2^3 = 8
        * */
        //0000 0001 -> 0000 1000 -> 2^3 = 8
        int a = 1 << 3;
        System.out.println(Integer.toBinaryString(1) + "\t" + Integer.toBinaryString(1 << 3) + "\t" + (1 << 3));

        /*
        * 解析 溢出左移
        * 1的二进制                                   左移33位溢出后返回最右边继续移位
        * 0000 0000 0000 0000 0000 0000 0000 0001 -> 0000 0000 0000 0000 0000 0000 0000 0010 -> 2^1 = 2
        * */
        System.out.println(Integer.toBinaryString(-1) + "\t" + Integer.toBinaryString(-1 << 64) + "\t" + (-1 << 64));

        System.out.println(3%32);



        System.out.println(0B0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L);

        System.out.println(Integer.toBinaryString(-1) + "\t" + Integer.toBinaryString(-1 << 3) + "\t" + (-1 << 3));

        System.out.println("----------------------------");
        //结果 10    1    1
        /*
        * 解析 正常右移
        * 1的二进制     右移一位
        * 0000 0010 -> 0000 0001 -> 2^0 = 1
        * */
        System.out.println(Integer.toBinaryString(2) + "\t" + Integer.toBinaryString(2 >> 1) + "\t" + (2 >> 1));
        //结果 11111111111111111111111111111101	11111111111111111111111111111111	-1
        /*
        * 解析 溢出右移
        * -3的二进制                         右移9位后
        * 11111111111111111111111111111101 -> 11111111111111111111111111111111 ->  -1
        *
        * 二进制负数的计算方式
        * 减1 取反 求十进制得绝对值
        * 减1  11111111111111111111111111111111 - 00000000000000000000000000000001 = 11111111111111111111111111111110
        * 取反 11111111111111111111111111111110 -> 00000000000000000000000000000001
        * 求十进制得绝对值 2^0 = 1
        * */
        System.out.println(Integer.toBinaryString(-3) + "\t" + Integer.toBinaryString(-3 >> 9) + "\t" + (-3 >> 9));
        System.out.println(Integer.toBinaryString(2) + "\t" + Integer.toBinaryString(2 >> 31) + "\t" + (2 >> 31));
        System.out.println(31%32);

        System.out.println("=======================================");
        //结果 11111111111111111111111111111111	11111111111111111111111111111	536870911
        /*
        * 解析
        * -1的二进制                         无符号右移三位后左边补0
        * 11111111111111111111111111111111	00011111111111111111111111111111	536870911
        * */
        System.out.println(Integer.toBinaryString(-1) + "\t" + Integer.toBinaryString(-1 >>> 3) + "\t" + (-1 >>> 3));

        //结果 100000	100	4
        /*
        * 解析
        * 32的二进制    无符号右移三位后
        * 0010 0000 -> 0000 0100 -> 4
        * */
        System.out.println(Integer.toBinaryString(32) + "\t" + Integer.toBinaryString(32 >>> 3) + "\t" + (32 >>> 3));

        System.out.println(Integer.toBinaryString(-1) + "\t" + Integer.toBinaryString(-1 >>> 16) + "\t" + (-1 >>> 16));

        System.out.println(16%32);
/*
        //0000 0010 -> 0001 0000 -> 2^4 = 16
        int b = 2 << 3;

        //0000 0011 -> 0001 1000 -> 2^4 + 2^3 = 16 + 8
        //2^4 + 2^3 = 16 + 8 = 24
        int c = 3 << 3;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //0000 0001 -> 0000 0000 001 -> 0
        int d = 1 >> 3;

        //0000 0010 -> 0000 0001 -> 1
        int e = 2 >> 1;

        //0000 0011 -> 0000 0000 11
        int f = 3 >> 2;

        System.out.println(d);
        System.out.println(e);
        System.out.println(f);


        // 1000 0011
        int h = -1 >>> 3;
        int i = 1 >>> 3;
        System.out.println(h);
        System.out.println(i);

        int j = 0B101;
        System.out.println(j);
        System.out.println(Integer.toBinaryString(-1));

        int k = 0B0111_1111_1111_1111_1111_1111_1111_1111;
        System.out.println(k);
        System.out.println(Math.pow(2, 30) +
                Math.pow(2, 29) +
                Math.pow(2, 28) +
                Math.pow(2, 27) +
                Math.pow(2, 26) +
                Math.pow(2, 25) +
                Math.pow(2, 24) +
                Math.pow(2, 23) +
                Math.pow(2, 22) +
                Math.pow(2, 21) + Math.pow(2, 20) + Math.pow(2, 19) +
                Math.pow(2, 18) + Math.pow(2, 17) +
                Math.pow(2, 16) +
                Math.pow(2, 15) +
                Math.pow(2, 14) +
                Math.pow(2, 13) +
                Math.pow(2, 12) +
                Math.pow(2, 11) +
                Math.pow(2, 10) +
                Math.pow(2, 9) +
                Math.pow(2, 8) +
                Math.pow(2, 7) +
                Math.pow(2, 6) +
                Math.pow(2, 5) +
                Math.pow(2, 4) +
                Math.pow(2, 3) +
                Math.pow(2, 2) +
                Math.pow(2, 1) +
                Math.pow(2, 0)
        );*/
    }
}
