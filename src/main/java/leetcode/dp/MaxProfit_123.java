package leetcode.dp;//

/**
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 */
public class MaxProfit_123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    //一天之中，buy1保存买入的最小价格

    /**
     * 一天之中，buy1保存买入的最小价格
     * sell1
     *
     */

    public static void main(String[] args) {
        MaxProfit_123 maxProfit_123 = new MaxProfit_123();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int i = maxProfit_123.maxProfit(prices);
        System.out.println(i);
    }

}
