package ctci.leetcode;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        char str[] = s.toCharArray();
        Set<String> wordSet = new HashSet(wordDict);
        //System.out.println(wordSet);
        return wordBreak(s, 0, s.length() - 1, wordSet);
    }

    public boolean wordBreak(String s, int start, int end, Set<String> wordSet) {
        if (start == end + 1)
            return true;
        System.out.println(s.substring(start, end + 1));
        System.out.println(start);
        for (int i = 0; start + i <= end; i++) {

            String temp = s.substring(start, start + i + 1);
            if (wordSet.contains(temp) && wordBreak(s, start + i + 1, end, wordSet)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        Set<Integer> set = new HashSet<>();
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(2);

        System.out.println(a1.compareTo(a2));
        String arr[] = new String[]{"leet", "code"};
        System.out.println(obj.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

}
