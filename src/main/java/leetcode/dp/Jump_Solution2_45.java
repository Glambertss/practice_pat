package leetcode.dp;//

public class Jump_Solution2_45 {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return 0;
        }
        int[] range = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            range[i] = i + nums[i];
        }
        int step = 0;
        int maxIndex = range[0];
            //代表当前能遍历到的最大下标
        int temp = -1;
        int lastVisitedIndex = 0;

        while(maxIndex < nums.length -1) {
            step++;
            for (int i = lastVisitedIndex + 1; i <= maxIndex; i++) {
                if (range[i] > temp) {
                    temp = range[i];
                    if (temp >= nums.length - 1) {
                        return ++step;
                    }
                }
            }
            lastVisitedIndex = maxIndex;
            maxIndex = temp;
        }
        return ++step;

    }

    public static void main(String[] args) {
        Jump_Solution2_45 jump_solution2_45 = new Jump_Solution2_45();
        int[] nums = new int[]{1, 2};
        System.out.println(jump_solution2_45.jump(nums));
    }



}
