package expressionEvaluator;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionConversion {
    // Operator has Left --> Right associativity
    public static boolean hasLeftAssociativity(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Operator having higher precedence
    // value will be returned
    public static int getPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 11;
        } else if (ch == '*' || ch == '/') {
            return 12;
        } else if (ch == '^') {
            return 13;
        }
        return -1;
    }

    public static String postfix(String infix) {
        StringBuilder output = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < infix.length(); ++i ) {
            char entity = infix.charAt(i);
            if (Character.isDigit(entity)) {
                output.append(entity);
            } else if (entity == '(') {
                stack.push(entity);
            } else if (entity == ')') {
                while (!stack.isEmpty() && !stack.peek().equals('(')) {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    System.out.println("ERROR: The expression has wrong parentheses !!!");
                }
            } else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && getPrecedence(entity) <= getPrecedence(stack.peek())
                        && hasLeftAssociativity(entity)) {
                    output.append(stack.pop());
                }
                stack.push(entity);
            }
        }

        while (!stack.isEmpty()) {
            if ( stack.peek().equals('(')) {
                System.out.println("ERROR: The expression has wrong parentheses !!!");

            } else {
                output.append(stack.pop());
            }
        }
        return output.toString();
    }
}