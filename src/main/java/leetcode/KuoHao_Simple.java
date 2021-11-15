package leetcode;//

import java.util.ArrayList;
import java.util.List;

public class KuoHao_Simple {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backTrack(result,"(",  1, 0, n);
        //利用栈，来实现括号的配对
        return result;
    }

    public String backTrack(List<String> result ,String currentString,  int left, int right, int n){
        if(left == n && right == n){
            result.add(currentString);
            return currentString;
        }
        if(right + 1 <= left && right + 1 <= n){
            backTrack(result, currentString + ")", left, right + 1, n);
        }
        if(left + 1 <= n){
            backTrack(result, currentString + "(", left + 1, right, n);
        }
        return currentString;
    }

    public static void main(String[] args) {
        KuoHao_Simple kuoHaoSimple = new KuoHao_Simple();
        List<String> strings = kuoHaoSimple.generateParenthesis(3);
        System.out.println(strings);

    }
}
