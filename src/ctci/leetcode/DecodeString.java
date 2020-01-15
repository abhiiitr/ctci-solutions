package ctci.leetcode;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        stringStack.push(new StringBuilder());

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                stringStack.push(new StringBuilder());
                numStack.push(num);
                num = 0; //reset for next nums
            } else if (ch == ']') {
                String toAppend = stringStack.pop().toString();
                int count = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    temp.append(toAppend);
                }
                stringStack.push(stringStack.pop().append(temp.toString()));
            } else {
                stringStack.peek().append(ch);
            }
        }

        return stringStack.pop().toString();
    }

    public static void main(String[] args) {

        DecodeString obj = new DecodeString();
        String s = "2[abc]3[cd]ef";
        //System.out.println(Character.isAlphabetic(s.charAt(0)));
        System.out.println(obj.decodeString(s));

    }
}
