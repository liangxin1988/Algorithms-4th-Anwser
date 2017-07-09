package Answer.chapter1.section1;

import Answer.base.Answer3Integer;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_3 extends Answer3Integer {
    @Override
    public void answer() {
        int a = getArgs1();
        int b = getArgs2();
        int c = getArgs3();
        print(a == b && b == c?"equal":"not equal");
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{2,2,2};
    }
}
