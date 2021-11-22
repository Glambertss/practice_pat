package leetcode.dp;//

public class Trap {
    public int solution(int[] height){

        //记录下当前最高的点
        int[] dp = new int[height.length];


        for(int i = 1; i < height.length; i ++) {

            if (height[i] == 0) {
                dp[i] = dp[i - 1];
            } else if (height[i] > height[i - 1]) {
                //则向前找到高度等于或者大于当前高度的墙， 然后进行赋值
                int tempMaxHeight = -1;
                int tempMaxHeightIndex = -1;

                for (int k = i - 1; k >= 0; k--) {
                    //找到前面高度中的最大值
                    if(height[k] > tempMaxHeight){
                        tempMaxHeight = height[k];
                        tempMaxHeightIndex = k;
                    }
                    if (height[k] >= height[i]) {
                        //然后从这个高度开始计算得出dp[i]的值
                        break;
                    }
                }
                int temp  = (i - tempMaxHeightIndex - 1) * Math.min(height[tempMaxHeightIndex], height[i]);
                //然后将k + 1 到 i -1 上
                for(int j = tempMaxHeightIndex + 1; j < i; j ++){
                    temp -= height[j];
                }
                if(temp < 0){
                    System.out.println();
                }
                dp[i] = dp[tempMaxHeightIndex] + temp;

            }else if(height[i] <= height[i - 1]){
                //找到上一个有高度的值
               dp[i] = dp[i -1];
            }
        }


        return dp[dp.length -1];
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights2 = new int[]{4,2,0,3,2,5};
        int[] heights3 = new int[]{9,6,8,8,5,6,3};
        int solution = trap.solution(heights3);
        System.out.println(solution);

    }
}
