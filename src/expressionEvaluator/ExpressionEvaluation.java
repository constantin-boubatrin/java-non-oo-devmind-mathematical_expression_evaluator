package expressionEvaluator;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionEvaluation {
    // A utility method to apply an operator 'op' on
    // operands 'a' and 'b'. Return the result
    public static int applyOperator(int op1, int op2, char operator) {
        switch (operator) {
            case '+':
                return op2 + op1;
            case '-':
                return op2 - op1;
            case '*':
                return op2 * op1;
            case '/':
                if(op1 == 0) {
                    throw new UnsupportedOperationException(
                            "Cannot divide by zero");
                }
                return op2 / op1;
            case '^':
                int result = 1;
                if(op1 == 0){
                    return 1;
                } else if (op2 == 0) {
                    return 0;

                } else {
                    while (op1 > 0) {
                        result *= op2;
                        op1--;
                    }
                    return result;
                }
            default:
                System.out.println();
        }
        return 0;
    }

    // Method to evaluate value of a postfix expression
    public static int evaluator(String expression) {
        Deque<Integer> stack = new LinkedList<>();
        String operators = "+-*/^";

        for (int i = 0; i < expression.length(); ++i) {
            char entity = expression.charAt(i);
            // Check if current token is a whitespace, skip it
            if (entity == ' ') {
                continue;
            }
            // Current token is a number,
            // push it to stack for numbers
            if (Character.isDigit(entity)) {
                stack.push(Integer.parseInt(String.valueOf(entity)));
            } else if (operators.indexOf(entity) != -1) {
                int op1, op2, result;
                if (stack.peek() != null) {
                    op1 = stack.pop();
                } else {
                    System.out.println("ERROR: ");
                    break;
                }
                if (stack.peek() != null) {
                    op2 = stack.pop();
                } else {
                    System.out.println("ERROR");
                    break;
                }
                result = applyOperator(op1, op2, entity);
                stack.push(result);
            }
        }

        int result = stack.pop();
        if (!stack.isEmpty()) {
            System.out.println("The post-fixed expression is wrong!!!");
            return 0;
        }
        return result;
    }
}