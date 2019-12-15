package ctci.leetcode;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0 || k > nums.length)
            return result;

        // Sort map based on values in reverse order
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        int i = 0;
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        return e2.getValue() - e1.getValue();
                    }
                });
        for (Map.Entry entry : map.entrySet()) {
            queue.add(entry);
        }
        while(!queue.isEmpty()) {
            if (i == k)
                break;
            result.add(queue.poll().getKey());
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();

        System.out.println(obj.topKFrequent(new int[]{2,3, 1, 2, 2, 3}, 2));
    }
}
