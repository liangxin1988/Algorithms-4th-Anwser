package Answer.chapter1.section3;

import Answer.base.Answer1String;
import data_structure.stack.FixedCapacityStackOfStrings;
import data_structure.stack.StackTestHelper;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_2 extends Answer1String {
    @Override
    public void answer() {
        String s = getArgs1();
        new StackTestHelper().stackTest(s,new FixedCapacityStackOfStrings(1100));
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"it was - the best - of times - - - it was - the - -"};
    }
}
