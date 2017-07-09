package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;

/**
 */
public class Ex_16 extends Answer0 {
    @Override
    public void answer() {
        print(exR1(6));  //311361142246
    }

    private static String exR1(int n){
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
