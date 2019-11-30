package ctci.chaptereight;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGrid {

    boolean end = false;

    public List<Point> findPath(int[][] arr) {

        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return null;
        List<Point> result = new ArrayList<>();
        findPath(arr, 0, 0, result);
        return result;
    }

    private void findPath(int[][] arr, int r, int c, List<Point> result) {
        if (r >= arr.length || c >= arr[0].length || arr[r][c] == -1)
            return;
        result.add(new Point(r, c));
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            end = true;
            return;
        }

        findPath(arr, r + 1, c, result);
        if (!end) {
            result.remove(result.size() - 1);
        }
        findPath(arr, r, c + 1, result);
        if (!end) {
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        RobotInAGrid obj = new RobotInAGrid();
        int arr[][] = {{0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}};
        final List<Point> path = obj.findPath(arr);

        for (Point e : path)
            System.out.print(e);
    }

    class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
