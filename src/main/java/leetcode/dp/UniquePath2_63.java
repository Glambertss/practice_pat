package leetcode.dp;//

public class UniquePath2_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] dp = new int[m + 1][n +1];

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if(i == 1 && j == 1){
                    dp[1][1] = 1;
                }else{
                    if(obstacleGrid[i -1][j - 1] == 1){
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];


    }

    public static void main(String[] args) {
        int[][] obj = new int[][]{{1}};
        UniquePath2_63 uniquePath2_63 = new UniquePath2_63();
        int i = uniquePath2_63.uniquePathsWithObstacles(obj);
        System.out.println(i);

    }

}
