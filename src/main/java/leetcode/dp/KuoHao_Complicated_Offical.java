package leetcode.dp;//

public class KuoHao_Complicated_Offical {
    public int solution(String s){
        char[] s_chars = s.toCharArray();
        if(s_chars.length == 0){
            return 0;
        }
        //dp[i]代表在i
        int dp[] = new int[s_chars.length];

        for(int i = 0; i < s_chars.length; i ++){
            if(i - 1 >= 0 && s_chars[i - 1] == '(' && s_chars[i] == ')' ){
                if(i - 2 >= 0) {
                    dp[i] = dp[i - 2] + 2;
                }else{
                    dp[i] = 2;
                }
            }else if(i -1 >= 0 && i - dp[i -1] -1 >= 0
                    && s_chars[i - 1] == ')'
                    && s_chars[i] == ')'
                    && s_chars[i - dp[i - 1] - 1] == '('){
                dp[i] = dp[i - 1] + 2;
            }
            if(i - dp[i] >= 0 && dp[i] > 0 && dp[i - dp[i]] > 0) {
                dp[i] = dp[i - dp[i]] + dp[i];
            }
        }
        //返回最大值
        int max = -1;
        for(int i = 0; i < dp.length; i ++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        KuoHao_Complicated_Offical kuoHao_complicated_offical = new KuoHao_Complicated_Offical();
       // int solution = kuoHao_complicated_offical.solution(")(((((()())()()))()(()))(");
        int solution = kuoHao_complicated_offical.solution("()");
        System.out.println("solution = " + solution);
    }
}
