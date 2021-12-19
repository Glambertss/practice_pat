package leetcode.dp;//

public class NumDecodings_91 {
    public int solution(String s) {
        String s_format = " " + s;
        char[] s_chars = s_format.toCharArray();

        int m = s.length();
        if (m == 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        if (s_chars[1] == '0') {
            return 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i <= m; i++) {
            if (s_chars[i] != '0') {
                //如果和前面的元素结合起来正好小于或者等于26，则加1
                if (s_chars[i - 1] != '0' &&
                        Integer.parseInt(s_format.substring(i - 1, i + 1)) <= 26) {

                    dp[i] = dp[i - 1] + ((i - 2) >= 1 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                //如果当前遍历的元素是0 ，则其一定要和前面的元素结合
                if (s_chars[i - 1] == '0'
                        || Integer.parseInt(s_format.substring(i - 1, i + 1)) > 26) {
                    return 0;
                } else {
                    dp[i] = (i - 2) >= 1 ? dp[i - 2] : 1;
                }
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        NumDecodings_91 numDecodings_91 = new NumDecodings_91();
        //System.out.println(numDecodings_91.solution("226"));
        System.out.println(numDecodings_91.solution("10"));
    }
}
