package ctci.leetcode;

import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    class Pair{
        int x1, x2;
        Pair(int x1, int x2){
            this.x1 = x1;
            this.x2 = x2;
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[][]{};
        List<Pair> result = new ArrayList<>();
        sortArray(intervals);
        int lower = intervals[0][0];
        int upper = intervals[0][1];
        if(intervals.length == 1)
            return new int[][]{{lower, upper}};

        for(int i = 1; i < intervals.length; i++){

            if(intervals[i][0] > upper){
                result.add(new Pair(lower, upper));
                lower = intervals[i][0];
                upper = intervals[i][1];
            } else if(intervals[i][0] <= upper && intervals[i][1] > upper){
                upper = intervals[i][1];
            }

        }
        result.add(new Pair(lower, upper));
        int[][] mergeResult = new int[result.size()][2];
        int k = 0;
        for(Pair p: result){
            mergeResult[k][0] = p.x1;
            mergeResult[k][1] = p.x2;
            k++;
        }

        return mergeResult;
    }

    public void sortArray(int[][] arr){
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            list.add(new Pair(arr[i][0], arr[i][1]));
        }
        Collections.sort(list, new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.x1 - o2.x1;
            }
        });
        int i = 0;
        for(Pair p: list){
            arr[i][0] = p.x1;
            arr[i][1] = p.x2;
            i++;
        }
    }

    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        obj.merge(new int[][]{{2,6},{8,10},{1,3},{7,7}});
    }
}
