package com.algo.exercise.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(validateParentheses("[(])"));
    }

    private static boolean validateParentheses(String input) {
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put(')', '(');
        parentheses.put(']', '[');
        parentheses.put('}', '{');

        Stack<Character> stringStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (parentheses.containsKey(input.charAt(i))) {
                Character pop = stringStack.pop();
                if (pop != parentheses.get(input.charAt(i))) {
                    return false;
                }
            } else
                stringStack.push(input.charAt(i));
        }
        return stringStack.isEmpty();
    }
}
