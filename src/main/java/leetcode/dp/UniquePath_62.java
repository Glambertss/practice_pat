package leetcode.dp;//

public class UniquePath_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if(i == 1 && j == 1){
                    dp[1][1] = 1;
                }else{
                    dp[i][j] = dp[i][j -1] + dp[i -1][j];
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        UniquePath_62 uniquePath_62 = new UniquePath_62();
        int i = uniquePath_62.uniquePaths(3, 3);
        System.out.println(i);

    }
}
