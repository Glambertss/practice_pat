package leetcode.dp;//

/**
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 */

public class MaxProfit_122 {
    public int maxProfit(int[] prices) {
        int[] temp = new int[prices.length -1];
        //temp[0] 代表 prices[1] - prices[0]
        for(int i = 0; i < prices.length -1; i ++){
            temp[i] = prices[i + 1] - prices[i];
        }
        int profit = 0;
        for(int i = 0; i < temp.length ; i ++){
            if(temp[i] > 0){
                profit += temp[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit_122 maxProfit_122 = new MaxProfit_122();
        int[] temp = new int[]{7,1,5,3,6,4};
        temp = new int[]{1, 2, 3, 4, 5};
        int i = maxProfit_122.maxProfit(temp);
        System.out.println(i);
    }


}
