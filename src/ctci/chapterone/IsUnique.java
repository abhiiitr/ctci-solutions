package ctci.chapterone;

public class IsUnique {

    /*Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?*/
    public static void main(String[] args) {
        // write your code here
        String input = "This string is not unique";
        String input2 = "Cowabung rt";
        System.out.println(isUniqueStringCharacters(input));
        System.out.println(isUniqueStringCharacters(input2));
    }

    private static boolean isUniqueStringCharacters(String input) {

        int[] ch = new int[128];
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            ch[val]++;
            if(ch[val] > 1)
                return false;
        }
        return true;
    }
}
