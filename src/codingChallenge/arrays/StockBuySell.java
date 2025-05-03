package codingChallenge.arrays;

public class StockBuySell {
    private static int maxProfit(int[] prices) {
        int buyValue = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyValue)
                buyValue = prices[i];
            else if (prices[i] - buyValue > profit)
                profit = prices[i] - buyValue;
        }
        return profit;
    }
}
