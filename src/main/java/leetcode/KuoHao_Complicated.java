package leetcode;//

public class KuoHao_Complicated {
    public int longestValidParentheses(String s) {
        char[] s_chars = s.toCharArray();
        if(s_chars.length == 0){
            return 0;
        }
        int[][] A = new int[s.length() + 1][s.length() + 1];

        for(int dist = 1; dist < s.length() + 1; dist ++ ){
            for(int j = 0; (j + dist) < s.length(); j ++){
                if(dist == 1){
                    if(s_chars[j] == '(' && s_chars[j + 1] == ')') {
                        A[j][j + 1]  = 2;
                    }
                }else{
                    if(dist % 2 == 1) {
                        // A[j][j + dist] 的值主要由 A[j][j +dist -1], A[j + 1][j +dist -1], A[j + 1][j + dist] 决定
                        if (j + 2 < s_chars.length && A[j][j + 1] == 2
                                && A[j + 2][j + dist] == dist - 1) {
                            //针对()()这种情况
                            A[j][j + dist] = dist + 1;
                        } else if((j + dist - 2) >= 0 && A[j][j + dist -2] == dist - 1 && A[j + dist -1][j + dist] == 2){
                            A[j][j + dist] = dist + 1;
                        } else if (A[j + 1][j + dist - 1] == dist - 1) {
                            if (s_chars[j] == '(' && s_chars[j + dist] == ')') {
                                //针对 ((()))这种情况
                                A[j][j + dist] = dist + 1;
                            } else {
                                A[j][j + dist] = Math.max(A[j][j + dist - 1], A[j + 1][j + dist]);
                                A[j][j +dist] = Math.max(A[j][j +dist], A[j + 1][j +dist -1]);
                            }
                        } else {
                            A[j][j + dist] = Math.max(A[j][j + dist - 1], A[j + 1][j + dist]);
                            A[j][j +dist] = Math.max(A[j][j +dist], A[j + 1][j +dist -1]);
                        }
                    }else{
                        A[j][j + dist] = Math.max(A[j][j + dist - 1], A[j + 1][j + dist]);
                        A[j][j +dist] = Math.max(A[j][j +dist], A[j + 1][j +dist -1]);
                    }
                }
            }
        }

      return A[0][s_chars.length - 1] ;

    }

    public static void main(String[] args) {
        KuoHao_Complicated kuoHao_complicated = new KuoHao_Complicated();
       System.out.println(kuoHao_complicated.longestValidParentheses(")(((((()())()()))()(()))("));
       // System.out.println(")((((()()()))()(()))(".length());

        //System.out.println(kuoHao_complicated.longestValidParentheses("()(())"));
    }

}
