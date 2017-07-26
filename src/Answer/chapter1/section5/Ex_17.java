package Answer.chapter1.section5;

import Answer.base.Answer0;
import Answer.base.Answer1Integer;
import Answer.base.Answer2Integer;
import algorithms.uf.IUF;
import algorithms.uf.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_17 extends Answer1Integer {
    @Override
    public void answer() {
        int N = getArgs1();
        println(count(N));
    }

    public static int count(int N){
        return ErdosRenyi.count(N,new WeightedQuickUnionUF(N));
    }

    private static class ErdosRenyi{

        static int count(int N,IUF uf){
            int count = 0;
            while(uf.count() != 1){
                int a = StdRandom.uniform(N);
                int b = StdRandom.uniform(N);

                count++;
                uf.union(a,b);
            }
            return count;
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{10};
    }
}
