package ctci.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ShortestPathInGridWithObstaclesElimination {
    /*Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or right from and to an empty cell.

    Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

    Example 1:
    Input:    grid =
            [[0,0,0],
            [1,1,0],
            [0,0,0],
            [0,1,1],
            [0,0,0]],
    k = 1
    Output: 6
    Explanation:
    The shortest path without eliminating any obstacle is 10.
    The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).*/
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        Map<String, Integer> memo = new HashMap<>();
        int min = shortestPath(grid, 0, 0, 0, k, visited, memo);

        return min == Integer.MAX_VALUE? -1: min;
    }

    public int shortestPath(int[][] grid, int row, int col, int len, int k, boolean[][] visited, Map<String, Integer> memo) {

        if (k < 0)
            return Integer.MAX_VALUE;
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 0;
        }
        String key = row + " " + col + " " + k;
        if (memo.containsKey(key))
            return memo.get(key);

        visited[row][col] = true;
        int r[] = {0, -1, 1, 0};
        int c[] = {-1, 0, 0, 1};
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int newRow = row + r[i];
            int newCol = col + c[i];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && !visited[newRow][newCol]) {
                int steps = 0;
                if (grid[newRow][newCol] == 1)
                    steps = shortestPath(grid, newRow, newCol, len + 1, k - 1, visited, memo);
                else
                    steps = shortestPath(grid, newRow, newCol, len + 1, k, visited, memo);
                if (steps != Integer.MAX_VALUE)
                    res = Math.min(res, steps + 1);
            }
        }
        memo.put(key, res);
        visited[row][col] = false;
        return res;

    }

    public static void main(String[] args) {
        ShortestPathInGridWithObstaclesElimination obj = new ShortestPathInGridWithObstaclesElimination();
        // {{0,1,0,1},{0,1,0,0},{0,0,1,0},{1,0,0,1},{0,1,0,0}}
        // 18
        System.out.println(obj.shortestPath(new int[][]{{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}, 18));

    }
}
