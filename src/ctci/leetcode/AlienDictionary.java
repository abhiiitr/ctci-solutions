package ctci.leetcode;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary obj = new AlienDictionary();
        System.out.println(obj.alienOrder(new String[]{"wrt","wrf","er","ett","rftt","te"}));
    }

    public String alienOrder(String[] words) {
        if(words.length == 0)
            return "";

        Map<Character, Set<Character>> graph = new HashMap<>();
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!graph.containsKey(ch))
                    graph.put(ch, new HashSet<>());
            }
        }
        int indegrees[] = new int[26];
        //Arrays.fill(-1);
        int n = words.length;

        // construct the graph
        for(int i = 0; i < n -1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++){
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if(ch1 != ch2){
                    // Add if not present in set for ch1
                    if(!graph.get(ch1).contains(ch2)){
                        graph.get(ch1).add(ch2);
                        indegrees[ch2-'a']++;
                    }
                    break;
                }
            }
        }

        // BFS on nodes with indegree = 0
        Queue<Character> queue = new LinkedList<>();
        for(Character key: graph.keySet()){
            if(indegrees[key-'a'] == 0)
                queue.add(key);
        }
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()){
            char ch = queue.poll();
            res.append(ch);
            Set<Character> neighbours = graph.get(ch);

            // Reduce the incoming edges for neighbours
            for(char ne: neighbours){
                indegrees[ne - 'a']--;
                if(indegrees[ne-'a'] == 0)
                    queue.add(ne);
            }
        }
        // If no cycle, it must be valid
        return res.length() == graph.size() ? res.toString(): "";
    }
}
