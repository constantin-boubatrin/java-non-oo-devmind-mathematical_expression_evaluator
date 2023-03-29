package expressionEvaluator;

public class Main {

    /** DRIVER CODE */
    public static void main(String[] args) {
        System.out.println("Conversion of the expression from " +
                "the infixed form to the postfixed form.");

        String infixForm = "3+(2+1)*2^3^2-8/(5-1*2/2)";
        System.out.println("Infix form: " + infixForm);

        String postfixForm = ExpressionConversion.postfix(infixForm);
        System.out.println("Postfix form: " + postfixForm);

        System.out.println("Evaluation of the expression, in the postfixed form.");
        String postfix = "3 2 1 + 2 3 2 ^ ^ * + 8 5 1 2 * 2 / - / -";
        System.out.println("Postfixed form: " + postfix);

        int result = ExpressionEvaluation.evaluator(postfix);
        System.out.println("Output: " + result);
    }
}