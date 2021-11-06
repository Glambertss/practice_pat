package leetcode;//

public class MaxSubArray {

    public static int solution(int[] nums) {
        boolean negativeFlag = true;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
            }
            if(nums[i] > 0){
                negativeFlag = false;
                break;
            }
        }
        if(negativeFlag){
            return maxValue;
        }
        int start = -1;
        int end = -1;
        int sum = 0;
        int preStart = -1;
        int preEnd = -1;
        int preSum = 0;


        for (int i = 0; i < nums.length; i++) {
            //如果当前的和小于或者等于0，则将当前的start和end记录到pre信息中
            int temp = sum + nums[i];
            if (temp <= 0) {
                start = -1;// 重新
                end = -1;
                sum = 0;
            } else {
                if(start == -1){
                    start = i;
                }
                end = i;
                sum = temp;
                if (sum > preSum) {
                    preStart = start;
                    preEnd = end;
                    preSum = sum;
                    //突然变成了小于0的值，说明当前的元素是小于0 的
                }
            }

        }

        return sum > preSum ? sum : preSum;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{-1000};
        int[] nums = new int[]{-2,-1,-3,2,-1,2,2,-1,4};
        System.out.println(solution(nums));

    }
}
