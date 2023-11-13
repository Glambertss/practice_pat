package leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * (2*((3-4)*5)) = -10
 *
 * ((2*3)-(4*5)) = -14
 *
 *
 * ((2*(3-4))*5) = -10
 * (((2*3)-4)*5) = 10
 *
 *
 *  2 => {2}
 *
 *  * => 跳过
 *
 *  2*3 =》{6}
 *
 *  - 跳过
 *
 *  4 =》 { 2, -2}
 *
 *  * =》跳过
 *
 *  5 =》{ 10 ，-10}
 *
 *
 */

public class DiffWaysToCompute_241 {

    public List<Integer> diffWaysToCompute(String expression) {
        HashMap<String, Set<Integer>> dp = new HashMap<String, Set<Integer>>();
        //存类似于 1->1 , {}
        int count = 0;
        for (char c : expression.toCharArray()) {
            if('0' <= c && '9' >= c){
                count ++;
            }
        }

        for(int i = 0; i < count; i ++){


        }

    }

    public static void main(String[] args) {

    }
}
