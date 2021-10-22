package leetcode;//

public class Stock_K {


    public static int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int[] changeToPreviousDay = new int[days - 1];

        int[][] deal = new int[days][days];
        for(int i = 0; i < days; i ++){
            for(int j = 0; j < i ; j ++){
                deal[i][j] = prices[j] - prices[i];
            }
            deal[i][i] = 0;
        }










        for (int i = 1; i < days; i++) {
             changeToPreviousDay[i - 1] = prices[i] - prices[i - 1];
        }

        //dp[i][j] 代表从第i天开始到第j天的能卖出的股票的最大的价格

        //changeToPreviousDay 的下标范围是从 0到 days -2
        int sum = 0;


        return -1;








        //切分 0- i, (i+1) - j, ....... (i + k) - (days -2)  分成三段
        //
    }

    public static int maxProfit(int[] changeToPreviousDay , int start, int end){
        int sum = 0;
        int temp = 0;
        for(int i = start; i <=end ; i ++){

            if(temp + changeToPreviousDay[i] > 0){
                temp = temp + changeToPreviousDay[i];
            }else{
                temp = 0;
            }

            if(temp > sum){
                sum = temp;
            }
        }
        return sum;
    }
}
