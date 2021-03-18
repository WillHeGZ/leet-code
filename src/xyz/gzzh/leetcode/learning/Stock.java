package xyz.gzzh.leetcode.learning;

import java.math.BigDecimal;

public class Stock {
    private final static BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    public static void main(String[] args) throws InterruptedException {
        BigDecimal number = ONE_HUNDRED.multiply(BigDecimal.valueOf(3));
        BigDecimal costPrice = BigDecimal.valueOf(5.873);
        BigDecimal sellPrice = BigDecimal.valueOf(5.82);

        BigDecimal result = sellPrice.multiply(number).subtract(costPrice.multiply(number));

        System.out.println(result);
    }
}
