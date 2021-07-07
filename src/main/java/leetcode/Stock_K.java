package leetcode;//

public class Stock_K {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int[] changeToPreviousDay = new int[days - 1];
        for (int i = 1; i < days; i++) {
             changeToPreviousDay[i - 1] = prices[i] - prices[i - 1];
        }

        //dp[i][j] 代表从第i天开始到第j天的能卖出的股票的最大的价格

        //changeToPreviousDay 的下标范围是从 0到 days -2
        int sum = 0;
        //计算将days 分成K个数字的和的情况，分别存储到相应的






        for (int i = 1; i < days - 1 - k; i ++ ) {

            int temp = maxProfit(changeToPreviousDay, 0, )  + maxProfit(changeToPreviousDay, i + 1, days -1);
            if(sum < temp){
                sum = temp;
            }

        }
        //切分 0- i, (i+1) - j, ....... (i + k) - (days -2)  分成三段
        //

    }

    /**
     * 将sum分成K段的情况放入到detail中去
     *
     * @param detail
     * @param sum
     * @param k
     * @return
     */
    public static int getConditions(int[][] detail, int sum ,int k){

        int count = 1; // 表示满足情况
        for(int j = 1; j <= k; j ++) {

            for (int i = 1; i <= sum - k + 1; i++) {
                detail[][j]=
            }
        }
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
