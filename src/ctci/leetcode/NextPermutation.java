package ctci.leetcode;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int n = nums.length - 1, index = -1, pivot = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                pivot = nums[i];
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, n);
            return;
        }

        for (int i = n; i >= 0; i--) {
            // find next greater element
            if (nums[i] > pivot) {
                swap(nums, index, i);
                break;
            }
        }

        reverse(nums, index + 1, n);

    }

    void reverse(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    void swap(int[] nums, int s, int e) {
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }


    public static void main(String[] args) {

        NextPermutation obj = new NextPermutation();

        obj.nextPermutation(new int[]{2, 3, 3});

    }
}
