package Answer.chapter1.section2;

import Answer.base.Answer1String;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_7 extends Answer1String {
    @Override
    public void answer() {
        String str = getArgs1();
        Checker.checkStringNull(str);
        println(mystery(str));
    }

    private String mystery(String s) {
        int N = s.length();
        if (N <= 1)
            return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a); // 这个方法是将字符串的前后两个部分倒置。递归以后每个字串也进行倒置，最后的结果就是整个字符串倒序排列。
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"123456789"};
    }
}
