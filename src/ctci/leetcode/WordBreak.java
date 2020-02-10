package ctci.leetcode;

import java.util.*;

public class WordBreak {
    Boolean[] visited;
    public boolean wordBreak(String s, List<String> dict){

        if( s== null || s.length() == 0 || dict == null || dict.size() == 0)
            return false;
        Set<String> set = new HashSet<>(dict);
        visited = new Boolean[s.length()];

        return wordBreak(s, set, 0);
    }

    public boolean wordBreak(String s, Set<String> dict, int start){
        if( start == s.length()){
            return true;
        }
        if(visited[start] != null)
            return visited[start];
        for(int i = start; i < s.length(); i++){
            String subStr = s.substring(start, i+1);
            if(dict.contains(subStr) && wordBreak(s, dict, i+1)){
                visited[i] = true;
                return true;
            }
        }
        visited[start] = false;
        return false;

    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        Set<Integer> set = new HashSet<>();
        System.out.println(obj.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

}
