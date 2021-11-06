package leetcode;//

public class HuiWen {

    public String longestPalindrome(String s) {
        int[][] a = new int[s.length()][s.length()];
        char[] s_chars = s.toCharArray();
        int huiWenStart = 0;
        int huiWenEnd = 0;
        int huiWenLength = 1;

        for(int k = 0; k < s.length(); k ++){
            for(int j = 0 ; j < s.length() - k; j ++){
                if(k == 0) {
                    a[j][j + k] = 1;
                }else if(k == 1){
                    if(s_chars[j] == s_chars[j + 1]){
                        a[j][j + 1] =2;
                    }else{
                        a[j][j] =1;
                    }
                }else {
                    if(a[j + 1][j + k -1] == k - 1){
                        if(s_chars[j] == s_chars[j + k]) {
                            a[j][j + k] = a[j + 1][j + k -1] + 2;
                        }else{
                            a[j][j + k] = Math.max(a[j + 1][j + k -1], a[j][j + k -1]);
                            a[j][j + k] = Math.max(a[j][j + k], a[j + 1][j + k]);
                        }
                    }else{
                        a[j][j + k] = Math.max(a[j + 1][j + k -1], a[j][j + k -1]);
                        a[j][j + k] = Math.max(a[j][j + k], a[j + 1][j + k]);
                    }
                }
                if(a[j][j + k] > huiWenLength){
                    huiWenStart = j;
                    huiWenEnd = j + k;
                    huiWenLength= a[j][j + k];
                }
            }
        }
        return s.substring(huiWenStart, huiWenEnd + 1);

    }

    public static void main(String[] args) {

        HuiWen huiWen = new HuiWen();
        System.out.println(huiWen.longestPalindrome("fesatersadarteardfafeatrfdasfaeafedf"));

    }
}
