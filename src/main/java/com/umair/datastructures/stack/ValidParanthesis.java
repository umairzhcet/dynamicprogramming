package com.umair.datastructures.stack;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid("(]"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() != '(') {
                    return false;
                } else if (c == '}' && stack.peek() != '{') {
                    return false;
                } else if (c == ']' && stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }

            } else {
                return stack.isEmpty();
            }

        }
        return stack.isEmpty();
    }
}
