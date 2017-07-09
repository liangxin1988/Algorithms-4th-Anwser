package Answer.chapter1.section1;

import Answer.base.Answer0;
import Answer.base.Answer1Integer;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_30 extends Answer1Integer{
    @Override
    public void answer() {
        int N = getArgs1();
        Checker.checkPlus(N);
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = (gcd(i, j) == 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                printf("%6s", a[i][j] ? "true" : "false");
            }
            println();
        }
    }
    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{10};
    }
}
