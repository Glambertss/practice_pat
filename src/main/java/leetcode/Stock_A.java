package leetcode;//

import jdk.nashorn.internal.ir.CallNode;

import java.util.Scanner;

public class Stock_A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int[] stockPriceInDay = new int[days + 1];
        int[] changeToPreviousDay = new int[days];
        for (int i = 1; i <= days; i++) {
            stockPriceInDay[i] = scanner.nextInt();
            if (i > 1) {
                changeToPreviousDay[i - 1] = stockPriceInDay[i] - stockPriceInDay[i - 1];
            }
        }

        //dp[i][j] 代表从第i天开始到第j天的能卖出的股票的最大的价格

        //changeToPreviousDay 的下标范围是从 1到 days -1
        int[][] dp = new int[days + 1][days + 1];
        int sum = 0;
        for (int i = 2; i <= days -1; i ++ ) {
            int temp = maxProfit(changeToPreviousDay, 1, i)  + maxProfit(changeToPreviousDay, i + 1, days -1);
            if(sum < temp){
                sum = temp;
            }
        }
        System.out.println(sum);

    }

    /**
     * 求数组changeToPreviousDay 从start开始到end（包括）结束中的最大值
     * @param changeToPreviousDay
     * @param start
     * @param end
     * @return
     */

    public static int maxProfit(int[] changeToPreviousDay , int start, int end ){
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
