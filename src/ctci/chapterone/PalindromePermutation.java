package ctci.chapterone;

public class PalindromePermutation {

    /*  Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards.
    A permutation is a rearrangement of letters.
    The palindrome does not need to be limited to just dictionary words.
    EXAMPLE Input: Tact Coa
    Output: True (permutations: " taco cat" . " atco cta" . etc.)*/

    public static void main(String[] args) {
        String input = "Tact Coa";
        System.out.println(isPalindromePermutation(input));
    }

    private static boolean isPalindromePermutation(String input) {
        // Ignoring case
        int count[] = new int[128], actualLength = 0;
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            //Ignoring spaces
            if(input.charAt(i) != ' ') {
                actualLength++;
                int index = input.charAt(i);
                count[index]++;
            }
        }

        int oddCount = 0;
        for(int i : count){
            if(i%2 != 0)
                oddCount++;
        }

        if(oddCount == 0 )
            return false;
        else{
            if(actualLength %2 != 0 && oddCount == 1)
                return true;
            else
                return false;
        }

    }
}

