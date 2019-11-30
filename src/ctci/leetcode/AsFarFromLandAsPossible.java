package ctci.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsFarFromLandAsPossible {



    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    int sum = maxDistance(grid, i, j, visited);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
    public int maxDistance(int[][] grid, int r, int c, boolean[][] visited) {
        if(r<0 || r >= grid.length || c < 0 || c>=grid[0].length || visited[r][c])
            return 0;
        if(grid[r][c] == 1)
            return 0;
        int currentSum = 0;
        if(grid[r][c] == 0){
            visited[r][c] = true;
            int s1 = maxDistance(grid, r-1, c,  visited);
            int s2 = maxDistance(grid, r, c-1,  visited);
            int s3 = maxDistance(grid, r+1, c,  visited);
            int s4 = maxDistance(grid, r, c+1,  visited);
            currentSum = 1 + Math.max(Math.max(s1,s2),Math.max(s3,s4));
        }
        visited[r][c] = false;
        return currentSum;
    }

    public static void main(String[] args) {
        AsFarFromLandAsPossible obj = new AsFarFromLandAsPossible();
        List<Integer> list = new ArrayList<>();
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        new ArrayList<ArrayList>();
        System.out.println(obj.maxDistance(grid));
    }
}
