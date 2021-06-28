package hd_judge;//

import java.util.Scanner;

public class MatrixMultiply {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixCount = scanner.nextInt();
        int[]  dimens= new int[matrixCount + 1];

        for(int i = 1; i <= matrixCount; i ++){
            dimens[i] = scanner.nextInt();
        }
        int[][] m = new int[matrixCount + 1][matrixCount + 1];




    }
}
