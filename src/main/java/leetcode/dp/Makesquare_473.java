package leetcode.dp;

/**
 *
 *
 * 1 2 1 3 1   4 4 4
 *  1 2 2 2 3   5 5 5
 * dp[0] = 1 dp[2] =
 * how to use the dp to dymanic select the elements
 *
 *   1 2 2 2 3
 *   dp[2] = 5
 *
 *   dp[3] = 7
 *
 *  5
 *
 *      1 1 2 3 4 4
 *
 *          1 1 3 =》 2 4 4
 *
 *      2 3 3 2
 *
 *
 *      dp[2][3] = 5
 *      dp[
 *
 *      1. 如何表示任意元素之间的组合
 *      2.
 *
 *
 */
public class Makesquare_473 {

    public boolean solution(int[] matchsticks) {
        int sum = 0;
        for (int length: matchsticks) {
            sum += length;
        }
        if(sum % 4 != 0){
            return false;
        }
        int target = sum / 4;


        for (int matchstick : matchsticks) {
            if(matchstick == target){

                continue;
            }
        }
        //







        



        //



        return false;



    }

    public static void main(String[] args) {

    }
}
