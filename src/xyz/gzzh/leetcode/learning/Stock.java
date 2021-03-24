package xyz.gzzh.leetcode.learning;

import java.math.BigDecimal;

public class Stock {
    private final static BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    public static void main(String[] args) throws InterruptedException {
        BigDecimal number = ONE_HUNDRED.multiply(BigDecimal.valueOf(8));
        BigDecimal buyPrice = BigDecimal.valueOf(5.859);
        BigDecimal sellPrice = BigDecimal.valueOf(6.0);

        BigDecimal buyAmount = buyPrice.multiply(number);
        BigDecimal sellAmount = sellPrice.multiply(number);
        BigDecimal commissionRatio = BigDecimal.valueOf(2.5).divide(BigDecimal.valueOf(10000));

        BigDecimal commissionAmount = buyAmount.multiply(commissionRatio);

        BigDecimal prepareSellPrice = buyAmount.add(buyAmount.multiply(BigDecimal.valueOf(80).divide(ONE_HUNDRED))).divide(number);
        BigDecimal prepareSellPriceCommissionAmount = prepareSellPrice.multiply(number).subtract(buyAmount);

        System.out.println("income amount : " + sellAmount.subtract(buyAmount));
        System.out.println("commission amount : " + commissionAmount);
        System.out.println("prepare sell price : " + prepareSellPrice);
        System.out.println("prepare sell price commission amount : " + prepareSellPriceCommissionAmount);
    }
}
