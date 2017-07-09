package Answer.chapter1.section2;

import Answer.base.Answer2String;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_6 extends Answer2String {
    @Override
    public void answer() {
        String str1 = getArgs1();
        String str2 = getArgs2();
        Checker.checkStringNull(str1,str2);
        println(((str1 + str1).indexOf(str2) != -1)
                && str1.length() == str2.length()); // 看了代码应该就理解了，不需要注释

    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"ACTGACG","TGACGAC"};
    }
}
