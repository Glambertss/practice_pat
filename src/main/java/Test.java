import leetcode.Solution;
import leetcode.Solution_Regex;

public class Test {
    public static void main(String[] args) {

        Solution_Regex pattern = new Solution_Regex();
        boolean aab = pattern.isMatch("mississippi",
                "mis*is*ip*.i");
        System.out.println("aab = " + aab);

        boolean aab2 = pattern.isMatch("misssp",
                "mis*p");
        System.out.println("aab2 = " + aab2);

/*        boolean ccd = pattern.isMatch("aaa", "ab*a*c*a");
        System.out.println("ccd = " + ccd);*/

        boolean ccd2 = pattern.isMatch("b", "ba*b*");
        System.out.println("ccd2 = " + ccd2);


        boolean ccd3 = pattern.isMatch("a", ".*..a");
        System.out.println("ccd3 = " + ccd3);


        /**
         * "mississippi"
         * "mis*is*ip*."
         */


        /**
         * "a"
         * ".*..a*"
         */



    }




}



