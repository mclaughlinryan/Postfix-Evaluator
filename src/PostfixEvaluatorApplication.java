import java.util.Scanner;

public class PostfixEvaluatorApplication {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please input a postfix expression element by element " +
                "that consists of integers (single or two digit) and mathematical operators " +
                "(+, -, *, /, ^, and %).");
        System.out.println("Example of a postfix expression:");
        System.out.println("7 8 * 41 + 2 36 % - = (7 * 8) + 41 - (36 % 2) = 56 + 41 - 0 = 95");
        System.out.println("Enter ')' as the final element in the expression.");

        int flagExitInput = 0;

        do {
            char[] inputChars = userInput.nextLine().toCharArray();

            if (inputChars[0] != ')') {
                for (int i = 0; i < inputChars.length; i++) {
                    buffer.append(inputChars[i]);
                }

                buffer.append(' ');
            }
            else {
                buffer.append(')');
                flagExitInput = 1;
            }
        } while (flagExitInput != 1);

        userInput.close();

        PostfixEvaluator postfixEvaluator = new PostfixEvaluator(buffer);

        float result = 0;
        result = postfixEvaluator.evaluatePostfixExpression();

        if(Float.valueOf(String.format("%.6f", result - (int)result)) == 0) {
            System.out.printf("The result of the postfix expression is %d", (int)result);
        }
        else {
            System.out.printf("The result of the postfix expression is %f", result);
        }
    }
}
