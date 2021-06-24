package xyz.gzzh.leetcode.learning;

import java.math.BigDecimal;

public class House {

    public static void main(String[] args) {
        BigDecimal nowAmount = new BigDecimal("15");
        BigDecimal needAmount = new BigDecimal("50");

        BigDecimal remainNeed = needAmount.subtract(nowAmount);

        System.out.println(remainNeed);

        System.out.println(2 * 6);
    }
}
