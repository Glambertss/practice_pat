package leetcode.dp;//

import java.util.HashSet;

public class IsScramble_87 {
    public boolean solution(String s1, String s2) {
        char[] s1_char = (" " + s1).toCharArray();
        char[] s2_char = (" " + s2).toCharArray();
        int m = s1.length();

        int[][] dp = new int[m + 1][m + 1];

        for(int distance= 0; distance <= m; distance ++){
            for(int i = 1; i + distance <= m; i += 1){
                if(distance == 0){
                    if(s1_char[i] == s2_char[i]){
                        dp[i][i] = 1;
                    }
                }else if(distance == 1){
                    dp[i][i + distance] = elementsEquals(s1_char, s2_char, i, i + 1);
                }else{
                    dp[i][i + distance] = elementsEquals(s1_char, s2_char, i, i + distance);
                    if(dp[i][i + distance] == 1){
                        //
                        dp[i][i + distance] = 0;
                        for(int k = i ; k < i + distance; k ++){
                            if(dp[i][k] + dp[k + 1][i + distance] == 2){
                                dp[i][i + distance] = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[1][m] == 1? true: false;
    }
    //返回1,表示s1_char[i ...j] 和s2_char[i ...j]包含相同的元素

    public int elementsEquals(char[] a, char[] b, int i, int j){
        HashSet<Character> aSet = new HashSet<>();
        HashSet<Character> bSet = new HashSet<>();

        for(int k = i; k <= j; k ++){
            aSet.add(a[k]);
            bSet.add(b[k]);
        }
        return aSet.equals(bSet) == true ? 1: 0;
    }

    public static void main(String[] args) {
        IsScramble_87 isScramble_87 = new IsScramble_87();
/*        boolean solution = isScramble_87.solution("abcde", "caebd");
        System.out.println("solution = " + solution);
        boolean solution1 = isScramble_87.solution("a", "a");
        System.out.println("solution1 = " + solution1);
        boolean solution2 = isScramble_87.solution("ab", "aa");
        //solution = isScramble_87.solution("abcde", "badec");
        System.out.println(solution2);
        boolean solution3 = isScramble_87.solution("abb", "abb");
        System.out.println("solution3 = " + solution3);*/
        boolean solution4 = isScramble_87.solution("abcdbdacbdac", "bdacabcdbdac");
        System.out.println("solution4 = " + solution4);

    }

    /**
     * "abcdbdacbdac"
     * "bdacabcdbdac"
     */


}
