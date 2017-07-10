package Answer.chapter1.section3;

import Answer.base.Answer1String;
import edu.princeton.cs.algs4.Stack;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_11 extends Answer1String {
    @Override
    public void answer() {
        String str = getArgs1();
        Checker.checkStringNull(str);
        println(new EvaluatePostfix().execute(str));
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"((12+)((34-)(96-)*)*)"};
    }

    /**
     * 对后序表达式进行求值，似乎比中序表达式求值简单，没加注释
     * */
    class EvaluatePostfix {
        double execute(String str) {
            Stack<Double> num = new Stack<>();

            for (char c : str.toCharArray()) {
                double a = 0, b = 0;
                switch (c) {
                    case '+':
                        num.push(num.pop() + num.pop());
                        break;
                    case '-':
                        a = num.pop();
                        b = num.pop();
                        num.push(b - a);
                        break;
                    case '*':
                        num.push(num.pop() * num.pop());
                        break;
                    case '/':
                        a = num.pop();
                        b = num.pop();
                        num.push(b / a);
                        break;
                    case ')':
                    case ' ':
                    case '(':
                        break;
                    default:
                        num.push(Double.parseDouble(c + ""));
                        break;
                }
            }
            return num.pop();
        }
    }
}
