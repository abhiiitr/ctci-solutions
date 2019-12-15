package ctci.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int n : nums)
            numsList.add(n);
        permute(0, result, numsList);

        return result;
    }

    public void permute(int index, List<List<Integer>> result, List<Integer> nums) {
        // Base condition when we reach the end and no int left
        if (index == nums.size())
            result.add(new ArrayList<>(nums));

        // Start from the index not from start since the number before is fixed
        for (int i = index; i < nums.size(); i++) {

            Collections.swap(nums, index, i);
            permute(index + 1, result, nums);
            // Back track
            Collections.swap(nums, index, i);
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        System.out.println(obj.permute(new int[]{1,2,3}));
    }

}
