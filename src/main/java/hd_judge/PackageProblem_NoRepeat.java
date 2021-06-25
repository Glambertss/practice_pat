package hd_judge;//

import java.util.Scanner;

public class PackageProblem_NoRepeat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int weightCanDure = scanner.nextInt();

        int items = scanner.nextInt();
        int[] prices = new int[items];
        int[] itemWeight = new int[items];
        for(int i = 0; i < items; i ++){
            itemWeight[i] = scanner.nextInt();
            prices[i] = scanner.nextInt();
        }

        //dp[i][j] i 个物品的时候（已作出选择），并且可以承受的重量为j的时候，价值

        int[][] dp = new int[items][weightCanDure + 1];
        for(int i = 0; i < items; i ++){
            for(int j = 0; j <= weightCanDure; j ++){

            }


        }


        for(int i = 0; i < items; i++ ){
            for(int j = 0 ; j <= weightCanDure;  j ++) {
                //i代表当前选择的物品的编号， j代表还能承受多少重量
                if(j >= itemWeight[i]) {
                    if(i >= 1){
                        dp[i][j] = max( dp[i -1][j], dp[i - 1][j -itemWeight[i]] + prices[i] );
                    }
                }
            }
        }

        System.out.println(dp[items -1][weightCanDure]);



    }
    public static int max(int x, int y){
        return x > y? x: y;
    }
}
