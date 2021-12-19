package leetcode.dp;//

public class NumTrees_96 {
    public int numTrees(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if(n <= 1){
            return dp[n];
        }
        for(int tempn = 2; tempn <= n; tempn ++){
            //一开始计算n比较小的数据
            for(int k = 0; k <= tempn - 1; k ++){
                dp[tempn] += dp[k] * dp[tempn -1 -k];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees_96 numTrees_96 = new NumTrees_96();
        System.out.println(numTrees_96.numTrees(2));

    }

}
