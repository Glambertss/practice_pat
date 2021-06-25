package hd_judge;//

import java.util.HashSet;
import java.util.Scanner;

/**
 * 输入：
 *      1
 *      3 2
 *      1 2 2
 *      1 3 3
 *
 * 输出
 *      10
 *
 */


public class TSP_Problem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int k = 0; k < testCase; k ++) {
            int cityNumber = scanner.nextInt();
            int[][] routesBetweenCity = new int[cityNumber + 1][cityNumber + 1];
            boolean[][] routesVisitedCondition = new boolean[cityNumber + 1][ cityNumber + 1];
            for(int i = 1; i < cityNumber + 1; i ++){
                for(int j = 1; j < cityNumber + 1; j ++){
                    routesBetweenCity[i][j] = Integer.MAX_VALUE;
                }
            }

            int routes = scanner.nextInt();
            HashSet<Integer> citiesRemainToVisit = new HashSet<>();
            for(int i = 2; i < cityNumber + 1; i ++){
                citiesRemainToVisit.add(i);
            }

            for (int i = 0; i < routes; i++) {
                int city1 = scanner.nextInt();
                int city2 = scanner.nextInt();
                int fuel = scanner.nextInt();
                routesBetweenCity[city1][city2] = fuel;
                routesBetweenCity[city2][city1] = fuel;
            }
            final int currentCity = 1;





        }


    }


 /*   public static int minDistance(int currentCity, HashSet<Integer> citiesRemainToVisit){
        for (Integer cityToVisit : citiesRemainToVisit) {

        }
    }*/

}
