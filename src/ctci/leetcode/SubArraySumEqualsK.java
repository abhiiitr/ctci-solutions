package ctci.leetcode;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int start = 0, end = 1, count = 0, currentSum = 0;
        while (start <= end && start < n && end < n) {
            currentSum += nums[end];
            if (currentSum >= k) {
                if (currentSum == k) {
                    count++;

                }
                currentSum -= nums[start];
                start++;
            }
            end++;
        }

        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK obj = new SubArraySumEqualsK();

        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
    }

}
