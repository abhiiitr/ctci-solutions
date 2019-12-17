package ctci.leetcode;

public class RangeSumQuery2D {
    /*
    Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Range Sum Query 2D
    The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
    Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8

    * */
    int[][] sum;
    int[][] matrix;
    int n, m;

    public RangeSumQuery2D(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        sum = new int[n + 1][m + 1];
        this.matrix = matrix;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // add prev row and col and subtract since i-1,j-1 is counted twice
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0)
            return 0;

        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        RangeSumQuery2D obj = new RangeSumQuery2D(new int[][]{{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});

        System.out.println(obj.sumRegion(2, 1, 4, 3));
    }

}
