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

    private static int count(int N){
        return new ErdosRenyi(N,new WeightedQuickUnionUF(N)).execute();
    }

    private static class ErdosRenyi{
        private int N;
        private IUF uf;

        ErdosRenyi(int N,IUF uf){
            this.N = N;
            this.uf = uf;
        }

        int execute(){
            int count = 0;
            while(uf.count() != 1){
                int a = StdRandom.uniform(N);
                int b = StdRandom.uniform(N);

                if(!uf.connected(a,b)){
                    count++;
                    uf.union(a,b);
                }
            }
            return count;
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{10};
    }
}
