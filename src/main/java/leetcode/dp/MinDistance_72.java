package leetcode.dp;//

import java.util.*;

public class MinDistance_72 {
    public int minDistance(String word1, String word2) {
        //求出最长公共子序列
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        char[] words1_char = (" " + word1).toCharArray();
        char[] words2_char = (" " + word2).toCharArray();

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <=m ; i ++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j ++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if( words1_char[i] == words2_char[j]){
                    dp[i][j] =  1 + Math.min(dp[i -1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i -1][j -1]);
                }else{
                    dp[i][j] =  1 + Math.min(dp[i -1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i -1][j -1] +  1);
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        MinDistance_72 minDistance_72 = new MinDistance_72();
         System.out.println(minDistance_72.minDistance("faefartgadfgre","sfeseafatredaf"));
        System.out.println(minDistance_72.minDistance("syxstion","szsqtion"));
        System.out.println(minDistance_72.minDistance("trkitm", "trditm"));
        System.out.println(minDistance_72.minDistance("intention", "execution"));
        System.out.println(minDistance_72.minDistance("horse", "ros"));
        System.out.println(minDistance_72.minDistance("teacher", "etcher"));
        System.out.println(minDistance_72.minDistance("mart", "karma"));
        System.out.println(minDistance_72.minDistance("sea", "ate"));

    }
}
