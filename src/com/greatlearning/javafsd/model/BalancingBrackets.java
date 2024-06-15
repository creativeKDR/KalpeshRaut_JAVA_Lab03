package com.greatlearning.javafsd.model;

import java.util.Stack;

public class BalancingBrackets {

    public static void main(String[] args) {

        String[] testInputs = {
                "([[{()}]])",
                "([[{()}]]))"
        };

        for (String input : testInputs) {
            System.out.println("Input: " + input);
            if (isBalanced(input)) {
                System.out.println("The entered String has Balanced Brackets");
            } else {
                System.out.println("The entered String does not contain Balanced Brackets");
            }
            System.out.println("--------------------------------------");
        }
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:

                    break;
            }
        }

        return stack.isEmpty();
    }
}

