package xyz.gzzh.leetcode.learning.juc;

import java.math.BigDecimal;

public class FunctionalInterfaceDemo {

    @FunctionalInterface
    interface Calculate {
        public BigDecimal calculate(BigDecimal... args);

        default BigDecimal add(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }

        default BigDecimal subtract(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }

        static BigDecimal multiply(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }

        static BigDecimal divide(BigDecimal x, BigDecimal y) {
            return x.divide(y);
        }
    }

    public static void main(String[] args) {
        Calculate calculate = (BigDecimal... args1) -> {
            System.out.println("这是代码模板生成的");
            return BigDecimal.ZERO;
        };

        System.out.println(calculate.calculate(null));
        System.out.println(calculate.add(BigDecimal.valueOf(1), BigDecimal.valueOf(2)));
        System.out.println(calculate.subtract(BigDecimal.valueOf(1), BigDecimal.valueOf(2)));
        System.out.println(Calculate.multiply(BigDecimal.valueOf(1), BigDecimal.valueOf(2)));
        System.out.println(Calculate.divide(BigDecimal.valueOf(1), BigDecimal.valueOf(2)));


    }
}
