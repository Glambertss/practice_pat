package introduction_to_algorithm;//

public class CommonSequence {

    public static int common(String s1, String s2) {
        char[] s1_chars = s1.toCharArray();
        char[] s2_chars = s2.toCharArray();

        int[][] A = new int[s1.length()][s2.length()];
        if (s1_chars[0] == s2_chars[0]) {
            for (int i = 0; i < s1.length(); i++) {
                A[i][0] = 1;
            }
            for (int i = 0; i < s2.length(); i++) {
                A[0][i] = 1;
            }
        }

        for(int i = 1; i < s1.length(); i ++){
            for(int j = 1; j < s2.length(); j ++){
                if(s1_chars[i] == s2_chars[j]){
                    A[i][j] = A[i -1][j -1] + 1;
                }else{
                    A[i][j] = Math.max(A[i - 1][j], A[i][j - 1]);
                }
            }
        }
        
        for(int i = 0; i < s1.length(); i ++){
            for(int j = 0; j < s2.length(); j ++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
      return A[s1.length() -1][s2.length() -1];
    }

    public static void main(String[] args) {
        System.out.println(common("babgbag", "bag"));
    }


}
