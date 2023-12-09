import java.lang.Math;

public class PostfixEvaluator {
    private StringBuffer postfixExpression;
    private StackInheritance<Float> stack = new StackInheritance<>();

    public PostfixEvaluator(StringBuffer postfixExpression) {
        this.postfixExpression = postfixExpression;
    }

    public float evaluatePostfixExpression() {

        while (getPostfixExpression().charAt(0) != ')')
        {
            do {
                if (String.valueOf(getPostfixExpression().charAt(0)).matches("-?[0-9]")) {
                    String numString = "";

                    do {
                        numString = numString.concat(String.valueOf(getPostfixExpression().charAt(0)));
                        getPostfixExpression().deleteCharAt(0);
                    } while (String.valueOf(getPostfixExpression().charAt(0)).matches("-?[0-9]"));

                    stack.push(Float.valueOf(numString));
                }
                else if (String.valueOf(getPostfixExpression().charAt(0)).matches("[-+*/%^]")) {
                    float x = stack.pop();
                    float y = stack.pop();

                    String operator = String.valueOf(getPostfixExpression().charAt(0));
                    getPostfixExpression().deleteCharAt(0);

                    float result = calculate(x, y, operator);

                    stack.push(result);
                }
            } while (getPostfixExpression().charAt(0) != ' ');

            getPostfixExpression().deleteCharAt(0);
        }

        return stack.pop();
    }

    private float calculate(float x, float y, String operator) {
        float result = 0;

        if (operator.matches("-")) {
            result = y - x;
        }
        else if (operator.matches("\\+")) {
            result = y + x;
        }
        else if (operator.matches("\\*")) {
            result = y * x;
        }
        else if (operator.matches("/")) {
            result = y / x;
        }
        else if (operator.matches("%")) {
            result = y % x;
        }
        else if (operator.matches("\\^")) {
            result = (int) Math.pow(y, x);
        }

        return result;
    }

    private StringBuffer getPostfixExpression() {
        return this.postfixExpression;
    }
}
