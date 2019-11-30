package ctci.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLengthConcatString1239 {
        private boolean isUnique(String str) {
            if (str.length() > 26) return false;
            boolean[] used = new  boolean [26];
            char[] arr = str.toCharArray();
            for (char ch : arr) {
                if (used[ch - 'a']){
                    return false;
                } else {
                    used[ch -'a'] = true;
                }
            }
            return true;
        }
        public int maxLength(List<String> arr) {
            List<String> res = new ArrayList<>();
            res.add("");
            for (String str : arr) {
                if (!isUnique(str)) continue;
                List<String> resList = new ArrayList<>();
                for (String candidate : res) {
                    String temp = candidate + str;
                    if (isUnique(temp)) resList.add(temp);
                }
                res.addAll(resList);
            }
            int ans = 0;
            for (String str : res) ans = Math.max(ans, str.length());
            return ans;

        }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String arr[] = {"cha","r","act","ers"};
        MaxLengthConcatString1239 obj = new MaxLengthConcatString1239();
        list = Arrays.asList(arr);
        System.out.print(obj.maxLength(list));
    }
}
