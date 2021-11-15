package leetcode;//

public class Trap {
    public int solution(int[] height){

        //记录下当前最高的点
        int heightToCompare = height[0];
        int index = 0;
        int sum = 0;
        //选取中间感兴趣的点，进行划分，然后分别求出
        final int n = height.length;

        int[][] A = new int[n + 1][n + 1];

        for (int dist = 1; dist < n + 1; dist++) {
            for (int j = 0; (j + dist) < n; j++) {
                if(dist == 1){
                    A[j][j + dist] = 0;
                }else{



                }

            }
        }


        return 0;
    }
}
