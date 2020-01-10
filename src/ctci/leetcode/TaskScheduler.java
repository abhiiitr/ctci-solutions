package ctci.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler obj = new TaskScheduler();
        System.out.println(obj.leastInterval(new char[]{'A','A','B','B','A','B'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0)
            return 0;
        int[] ch = new int[26];
        // Get the frequency of characters
        for (char c : tasks)
            ch[c - 'A']++;

        // Store the freq in decreasing order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int i = 0; i < 26; i++) {
            // add positive freq only
            if (ch[i] > 0)
                pq.add(ch[i]);
        }

        int i = 0, time = 0;
        List<Integer> temp;
        // start counting the cycles and store the used number in a temp list
        while (!pq.isEmpty()) {
            temp = new ArrayList<>();
            i = 0;
            while (i <= n && !pq.isEmpty()) {
                int k = pq.poll();
                if (k - 1 > 0)
                    temp.add(k);
                // Add to the time
                time++;
                if (pq.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int elem : temp)
                pq.add(elem);
        }

        return time;

    }
}
