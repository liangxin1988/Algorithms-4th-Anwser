package Answer.chapter1.section1;

import Answer.base.Answer2Double;

import static edu.princeton.cs.algs4.StdOut.print;

/**
 */
public class Ex_5 extends Answer2Double {

    @Override
    public void answer() {
        double num1 = getArgs1(),
                num2 = getArgs2();
        print(num1 > 0 && num1 < 1 && num2 > 0 && num2 < 1);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{0.5d,0d};
    }
}
