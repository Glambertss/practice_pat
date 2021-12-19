package leetcode.dp;//

import java.util.List;

public class PartitionHuiWen_131 {
    public List<List<String>> solution(String s){
        //从s的低位开始寻找切分点，假设切分点是q，那么从s.subString(0, q + 1)是回文串
        //然后再对余下的进行分割
        //需要知道s中的前k个字符对应的集合
        int m = s.length();
        int dp[] = new int[m];
        dp[0] = 1;

        for(int i = 1; i < m; i ++ ){
            //如果s[i]和前面的构成回文串
            //如果s[i -1]是所在回文串的最后一个
            for(int k = i - 1 ; k >= 0; k --){
                //

            }

        }

    }

    public static void main(String[] args) {

    }
}
/**
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 *
 */
