package common;//

public class ArrayUtil {

    public static void init2DArray(int value, int[][] array, int rowCount, int listCount){
        for(int i = 0; i < rowCount; i ++){
            for(int j = 0; j < listCount; j ++){
                array[i][j] = value;
            }
        }
    }
}
