package leetcode.dp;//

public class Regex2 {
    public boolean isMatch(String s, String p){
        int dp[][] = new int[s.length() + 1][p.length() + 1];
        char[] s_chars = s.toCharArray();
        char[] p_chars = p.toCharArray();

        if(s.length() == 0){
            for(int j = 0; j < p.length(); j ++){
                if(p_chars[j] != '*'){
                    return false;
                }
            }
            return true;
        }
        if(p.length() == 0){
            if(s.length() > 0){
                return false;
            }else{
                return true;
            }
        }


        for(int j = 0; j < p.length(); j ++){
            if(p_chars[j] == '*'){
                if(j == 0){
                    dp[0][j] = 1;
                }else{
                    dp[0][j] = dp[0][j -1];
                }
            }/*else if(p_chars[j] == '?'){
                if(j == 0){
                    dp[0][j] = 1;
                }else{
                    //查找前面是否出现出现过
                    if(p_chars[j - 1] == '*'){
                        dp[0][j] = dp[0][j - 1];
                    }
                }
            }*/else{
                if(j == 0){
                    if(s_chars[0] == p_chars[0] || p_chars[0] == '?'){
                        dp[0][0] = 1;
                    }
                }else{
                    //查找前面是否都是 * ，如果都是 则进行下面的判断
                    boolean flag = false;
                    for(int k = j -1; k >=  0; k --){
                        if(p_chars[k] != '*'){
                            flag = true;
                        }
                    }
                    if(flag == false) {
                        if (s_chars[0] == p_chars[j] ||p_chars[j] == '?') {
                            dp[0][j] = dp[0][j - 1];
                        }
                    }
                }
            }
        }

        for(int i = 0; i < s.length(); i ++){
            if(p_chars[0] == '*'){
                dp[i][0] = 1;
            }else{
                if(i == 0){
                    if(p_chars[0] == s_chars[0] || p_chars[0] == '?'){
                        dp[0][0] = 1 ;
                    }
                }
                break;
            }
        }


        for(int i = 1; i < s.length(); i ++){
            for(int j = 1; j < p.length(); j ++){
                if(p_chars[j] == '*'){
                    //则
                    dp[i][j] = Math.max(dp[i -1][j -1], dp[i -1][j]);
                    dp[i][j] = Math.max(dp[i][j -1], dp[i][j]);
                }else if(p_chars[j] == '?'){
                    dp[i][j] = dp[i -1][j -1];
                }else{
                    if(s_chars[i] == p_chars[j]){
                        dp[i][j] = dp[i -1][j -1];
                    }
                }
            }
        }
        return dp[s.length() -1][p_chars.length -1] == 1 ? true: false;
    }
    public static void main(String[] args) {
        Regex2 regex2 = new Regex2();
        System.out.println(regex2.isMatch("b", "?*?"));
    }
}
