package leetcode.dp;//

public class MinPathSum_64 {
    public int solution(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1; i < m; i ++){
            grid[i][0] = grid[i -1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j ++){
            grid[0][j] = grid[0][j -1] + grid[0][j];
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                grid[i][j] = Math.min(grid[i -1][j] , grid[i][j -1]) + grid[i][j];
            }
        }
        return grid[m- 1][n -1];
    }

    public static void main(String[] args) {
        MinPathSum_64 minPathSum_64 = new MinPathSum_64();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid2 = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum_64.solution(grid));

    }
}
