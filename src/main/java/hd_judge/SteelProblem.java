package hd_judge;//

import common.ArrayUtil;

import java.util.Random;

public class SteelProblem {

    public static void main(String[] args) {
        final int MIN = -1;
        int n =10;
        //0 舍弃，从1开始
        int price[] = new int[n];
        Random random = new Random();
        for(int i = 0; i < n ; i ++){
            price[i] = random.nextInt(20);

            System.out.print(price[i] + "  ");
        }
        System.out.println();

        //状态从0开始， 0代表所有的都没访问过
        int dp[][] = new int[1 << n ][n];
        int value[][] = new int[1 << n][n];

        ArrayUtil.init2DArray(MIN, value, 1 << n, n);

        value[1][0] = price[price.length -1];
        dp[1][0] = 1;//1代表切


    }

}
