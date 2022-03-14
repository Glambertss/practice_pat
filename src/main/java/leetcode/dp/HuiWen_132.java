package leetcode.dp;//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HuiWen_132 {

    public int minCut(String s) {
        boolean[][] f;
        int n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++ i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        //设置dp[index]为s的对应的0到index最小分割次数
        int[] dp = new int[n];

        dp[0] = 0;
        for(int i = 1; i < n; i ++){
            dp[i] = Integer.MAX_VALUE;
            if(f[0][i] == true){
                dp[i] = 0;
            }else {
                for (int j = 0; j < i; j++) {
                    if(f[j + 1][i] == true
                            && (dp[j] + 1) < dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        return dp[n -1];
    }



    public static void main(String[] args) {
        String s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
        s = "ab";
        s = "fhtth";
        HuiWen_132 huiWen_132 = new HuiWen_132();
        int i = huiWen_132.minCut(s);
        System.out.println("i = " + i);

    }
}
