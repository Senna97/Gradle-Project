package week05.e1021.algorithm;

import java.util.Stack;

public class CorrectBracket {

    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if (')' == s.charAt(i)) {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.empty();
    }
}