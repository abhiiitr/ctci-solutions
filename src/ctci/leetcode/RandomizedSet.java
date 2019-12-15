package ctci.leetcode;

import java.util.*;

class RandomizedSet {

    Map<Integer, Integer> map;
    int size;
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        size = 0;
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.get(val) != null)
            return false;
        else
            map.put(val, size);
        if (size > 0)
            list.set(size, val);
        else
            list.add(val);
        size++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (size == 0 || map.get(val) == null)
            return false;
        else {
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
            list.remove(list.size() - 1);
            map.remove(val);
            size--;
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(size);
        return list.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.remove(0);
        boolean param_2 = obj.remove(2);
        obj.insert(0);
        int param_3 = obj.getRandom();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        param_1 = obj.remove(0);
        param_2 = obj.insert(0);
//        param_3 = obj.getRandom();
        System.out.println(param_1);
        System.out.println(param_2);
//        System.out.println(param_3);
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for(int i = 0; i < k; i++)
            minHeap.add(nums[i]);

        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()) {
                if (minHeap.size() == k)
                    minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        System.out.println(minHeap.peek());
    }

}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */