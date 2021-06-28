package hd_judge;//

import common.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class SteelProblem {

    public static void main(String[] args) {
        final int MIN = -1;
        int n =10;
        //0 舍弃，从1开始
        int price[] = new int[n + 1];
        Scanner  scanner = new Scanner(System.in);
        Random random = new Random();
        for(int i = 1; i <= n ; i ++){
            price[i] = scanner.nextInt();
        }
        System.out.println();

        //状态从0开始， 0代表所有的都没访问过
        int dp[] = new int[n + 1];


        // 最大价值= max(p[i], dp[i]) p[i]代表第i -1 段不切，另一种情况是第i -1 段切
        //其中dp[i] = dp[i - 1] + p[1]

        //m[x] 代表第x段的最大值
        dp[0] = 0;

        for(int k = 1; k <= n;  k ++) {
            int q = -1;

            for (int j = 1; j <= k; j++) {
                q = ArrayUtil.max(q, price[j] + dp[k - j]);
            }
            dp[k] = q;
        }


        System.out.println("dp[] = " + dp[n]);


    }

}
