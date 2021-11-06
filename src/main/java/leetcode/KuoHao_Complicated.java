package leetcode;//

public class KuoHao_Complicated {
    public int longestValidParentheses(String s) {

        int countForLeft = 0;
        int countForRight = 0;
        char[] s_chars = s.toCharArray();
        int index = 0;
        int temp = 0;

        while(index < s.length()){
            if(s_chars[index ++] == '('){
                countForLeft += 1;
            }
            if(s_chars[index ++] == ')') {
                countForRight += 1;
            }
            if(countForRight > countForLeft){
                //无效，重新开始计数
                if(Math.min(countForLeft, countForRight) > temp){
                    temp = Math.min(countForLeft, countForRight);
                }
                countForLeft = 0;
                countForRight = 0;
            }
        }
        return  temp;

    }

    public static void main(String[] args) {
        KuoHao_Complicated kuoHao_complicated = new KuoHao_Complicated();
        System.out.println(kuoHao_complicated.longestValidParentheses("))()()()))()()()()((((()()()((()()"));
    }

}
