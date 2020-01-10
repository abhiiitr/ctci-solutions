package ctci.leetcode;

import java.util.*;

public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        if (points.length == 0 || points[0].length == 0)
            return 0;

        int m = points.length;
        int n = points[0].length;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });
        Map<Double, HashSet<int[]>> slopeMap = new HashMap<>();
        int maxPoints = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                // If x are same, means slope is infinity
                if (points[i][0] == points[j][0]) {
                    if (!slopeMap.containsKey(Double.MAX_VALUE))
                        slopeMap.put(Double.MAX_VALUE, new HashSet<>());
                    slopeMap.get(Double.MAX_VALUE).add(new int[]{points[j][0], points[j][1]});

                    maxPoints = Math.max(maxPoints, slopeMap.get(Double.MAX_VALUE).size());
                } else {
                    int y = points[j][1] - points[i][1];
                    int x = points[j][0] - points[i][0];
                    double slope = y / x;
                    if (!slopeMap.containsKey(slope))
                        slopeMap.put(slope, new HashSet<>());

                    slopeMap.get(slope).add(new int[]{points[j][0], points[j][1]});

                    maxPoints = Math.max(maxPoints, slopeMap.get(slope).size());
                }
            }
        }

        return maxPoints;
    }

    public static void main(String[] args) {

        MaxPointsOnALine obj = new MaxPointsOnALine();
        obj.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});

    }

}
