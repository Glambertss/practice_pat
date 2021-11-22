package leetcode.dp;//

public class Jump_45 {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return 0;
        }
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j < nums.length; j ++){
                dp[i][j] = -1;
            }
        }

        for(int dist = 0; dist < nums.length; dist ++) {
            for (int j = 0; j + dist < nums.length; j ++) {
                //当前查看点dp[j][j + dist]
                if(dist == 0){
                    dp[j][j + dist] = 0;
                }else{
                    if(nums[j] + j >= j + dist){
                        dp[j][j + dist] = 1;
                    }else{
                        //寻找从i点跳到j点最小跳跃次数的中间点
                        int minTemp = 999;
                        for(int k = j + 1; k < j + dist; k ++){
                            //如果中途找到了只需要跳跃2次的点，则直接中断查找
                            if(dp[j][k] >= 0 && dp[k][j + dist] >= 0) {
                                if (dp[j][k] + dp[k][j + dist] == 2){
                                    minTemp = 2;
                                    //剪枝
                                    break;
                                }else{
                                    if (dp[j][k] + dp[k][j + dist] < minTemp){
                                        minTemp = dp[j][k] + dp[k][j + dist];
                                    }
                                }
                            }

                        }
                        dp[j][j + dist] = minTemp;
                    }
                }

            }
        }
        return dp[0][nums.length -1];

    }


    public static void main(String[] args) {
        int[] temp = new int[]{2,1,0,1,4};
        Jump_45 jump_45 = new Jump_45();
        System.out.println(jump_45.jump(temp));

    }
}
