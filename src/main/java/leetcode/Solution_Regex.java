package leetcode;//

public class Solution_Regex {
    public boolean isMatch(String s, String p) {


        char[] s_char = s.toCharArray();
        char[] pattern_char = p.toCharArray();

        int[][] judge = new int[s_char.length][pattern_char.length];


        for(int i = 0; i < s_char.length; i ++){
            for(int j = 0; j < pattern_char.length; j ++){
                if(pattern_char[j] != '*') {
                    if (pattern_char[j] == '.' || s_char[i] == pattern_char[j]){
                        if(i == 0 ){
                            if(j == 0) {
                                judge[i][j] = 1;
                            }
                        }else{
                            judge[i][j] = judge[i - 1][j - 1];
                        }
                    }
                }else{
                    //如果j指向的匹配串当前的是* ，则j一定大于或者等于1
                    if(i == 0 ){
                        //如果位于第一行
                        if(j == 1) {
                            if (pattern_char[j - 1] == '.' || pattern_char[j - 1] == s_char[i]) {
                                judge[i][j] = 1;
                            }
                        }else{
                            judge[0][j] = judge[0][j - 1];
                        }
                    }else{
                        //如果当前位于第一行
                        if(pattern_char[j - 1] == '.' || pattern_char[j - 1] == s_char[i]){
                            judge[i][j] = Math.max(judge[i - 1][j -1], judge[i -1][j]);
                        }else{
                            if(j - 2 >= 0) {
                                judge[i][j] = judge[i][j - 2];
                            }
                        }
                    }


                }
                System.out.print(judge[i][j] + " ");

            }
            System.out.println();
        }



        return judge[s_char.length -1][pattern_char.length - 1] == 1 ? true: false;

    }


}
