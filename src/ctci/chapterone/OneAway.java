package ctci.chapterone;

import java.util.HashMap;
import java.util.Map;

public class OneAway {
    /*One Away: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
    EXAMPLE
    pale, ple -> true
    pales. pale -> true
    pale. bale -> true
    pale. bake -> false*/

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("pale", "ple");
        System.out.println(isOneAway("pale", map.get("pale")));
        map.put("pales", "pale");
        System.out.println(isOneAway("pales", map.get("pales")));
        map.put("pale", "bale");
        System.out.println(isOneAway("pale", map.get("pale")));
        map.put("pale", "bake");
        System.out.println(isOneAway("pale", map.get("pale")));

    }

    private static boolean isOneAway(String input1, String input2) {

        boolean isOneAway = false;
        int diff = input1.length() - input2.length();
        if (Math.abs(diff) == 1) {
            isOneAway = canInsertOrRemove(input1, input2);
        } else if (diff == 0) {
            isOneAway = canReplace(input1, input2);
        }

        return isOneAway;


    }

    private static boolean canReplace(String input1, String input2) {

        boolean isPossible = false;
        char ch1, ch2;

        for (int i = 0; i < input2.length(); i++) {
            ch1 = input1.charAt(i);
            ch2 = input2.charAt(i);
            // If characters are not same
            if (ch1 != ch2) {
                if (isPossible) {
                    isPossible = false;

                    break;
                }
                isPossible = true;
            }
        }
        return isPossible;
    }

    private static boolean canInsertOrRemove(String input1, String input2) {
        int diff = 0;
        char ch1, ch2;

        if (input1.length() < input2.length()) {
            String temp = input1;
            input1 = input2;
            input2 = temp;
        }
        for (int i = 0, j = 0; i < input2.length(); i++, j++) {
            ch1 = input1.charAt(i);
            ch2 = input2.charAt(j);
            // If characters are not same
            if (ch1 != ch2) {
                i++;
                diff++; // Increase the difference
            }
        }

        return diff <= 1;
    }
}
