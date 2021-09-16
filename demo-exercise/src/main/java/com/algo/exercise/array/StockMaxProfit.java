package com.algo.exercise.array;

public class StockMaxProfit {
    public static void main(String[] args) {
        System.out.println(checkMaxProfitMulti(new int[] {7, 1, 5, 3, 6, 4}));
    }

    //One time purchase and sell
    private static int checkMaxProfit(int [] stockPrices) {
        if (stockPrices.length == 0)
            return 0;
        int maxProfit = 0;
        int buyAt = stockPrices[0];
        for (int i = 1; i < stockPrices.length; i++) {
            maxProfit = Math.max(maxProfit, stockPrices[i] - buyAt);
            if (buyAt > stockPrices[i])
                buyAt = stockPrices[i];
        }
        return maxProfit;
    }

    //multiple times purchase and sell
    private static int checkMaxProfitMulti(int [] stockPrices) {
        if (stockPrices.length == 0)
            return 0;
        int maxProfit = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            if (stockPrices[i] > stockPrices[i - 1])
                maxProfit += (stockPrices[i] - stockPrices[i - 1]);
        }
        return maxProfit;
    }
}
