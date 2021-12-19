package leetcode.dp;//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal_120 {
    public int solution(List<List<Integer>> triangle) {
        int currentLevel = triangle.size() -1;
        int sum = 0;
        while(currentLevel > 0) {
            List<Integer> currentLevelElements = triangle.get(currentLevel);
            List<Integer> preLevelElements = triangle.get(currentLevel - 1);
            for(int i = 0; i < preLevelElements.size(); i ++){
                Integer preLevelElement = preLevelElements.get(i);
                preLevelElements.set(i, Math.min(preLevelElement + currentLevelElements.get(i), preLevelElement + currentLevelElements.get(i + 1)));
            }
            currentLevel --;

        }
        sum += triangle.get(0).get(0);

        return sum;
    }

    public static void main(String[] args) {
        MinimumTotal_120 minimumTotal_120 = new MinimumTotal_120();

        //int solution = minimumTotal_120.solution(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)));
        int solution = minimumTotal_120.solution(Arrays.asList(Arrays.asList(-10)));
        System.out.println(solution);
    }

}


/**
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
