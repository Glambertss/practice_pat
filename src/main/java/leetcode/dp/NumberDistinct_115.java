package leetcode.dp;//

public class NumberDistinct_115 {
//题目连接：https://leetcode-cn.com/problems/distinct-subsequences/
    public int solution(String s, String t) {
        char[] s1_chars = s.toCharArray();
        char[] s2_chars = t.toCharArray();

        int[][] A = new int[s.length()][t.length()];
        int[][] dp = new int[s.length()][t.length()];
        //dp[i][j]表示s1[i] 是否等于s2[j]
        if (s1_chars[0] == s2_chars[0]) {
            for (int i = 0; i < s.length(); i++) {
                A[i][0] = 1;
            }
            for (int i = 0; i < t.length(); i++) {
                A[0][i] = 1;
            }
        }

        for(int i = 1; i < s.length(); i ++){
            for(int j = 1; j < t.length(); j ++){
                if(s1_chars[i] == s2_chars[j]){
                    //标记出当值相等的点
                    dp[i][j] = 1;
                    A[i][j] = A[i -1][j -1] + 1;
                }else{
                    A[i][j] = Math.max(A[i - 1][j], A[i][j - 1]);
                }
            }
        }

        for(int i = 0; i < s.length(); i ++){
            for(int j = 0; j < t.length(); j ++){
                //当遍历到dp[i][j]并且其值为1的时候，从左上角，注意不包含当前的行和列，来统计到达该点的路径长度
                //注意：其只考虑一列的值，并且其上面的A[][]的值要是
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i = 0; i < s.length(); i ++){
            for(int j = 0; j < t.length(); j ++){
                //当遍历到dp[i][j]并且其值为1的时候，从左上角，注意不包含当前的行和列，来统计到达该点的路径长度
                //注意：其只考虑一列的值，并且其上面的A[][]的值要是
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        int count = 0;


      /*  for(int i = 0; i < s.length(); i ++){
            for(int j = 0; j < t.length(); j ++){
                //当遍历到dp[i][j]并且其值为1的时候，从左上角，注意不包含当前的行和列，来统计到达该点的路径长度
                //注意：其只考虑一列的值，并且其上面的A[][]的值要是
                if(dp[i][j] >= 1 && j > 0) {
                    for (int k = 0; k < i ; k ++ ){
                        if(A[k][j -1] == A[i][j] - 1){
                            dp[i][j] += dp[k][j - 1];
                        }
                    }
                }
            }
        }

        for(int i = 0; i < s.length(); i ++){
            if(A[i][t.length() -1 ] == t.length()){
                count += dp[i][t.length() -1];
            }
        }*/



        /**
         * 标记出当
         */
        return count;
    }

    public static void main(String[] args) {
        NumberDistinct_115 numberDistinct_115 = new NumberDistinct_115();
        //int solution = numberDistinct_115.solution("babgbag", "bag");
       int solution = numberDistinct_115.solution("rabbbit", "rabbit");
        System.out.println("solution = " + solution);


    }
}
/**
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 */

/**
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 */
