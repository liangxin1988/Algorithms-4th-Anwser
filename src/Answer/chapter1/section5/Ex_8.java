package Answer.chapter1.section5;

import Answer.base.Answer0;
import algorithms.uf.IUF;
import algorithms.uf.QuickFindUF;
import algorithms.uf.WrongQuickFindUF;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_8 extends Answer0 {
    @Override
    public void answer() {
        Test(new QuickFindUF(5));
        Test(new WrongQuickFindUF(5));
    }

    private void Test(QuickFindUF uf){
        for(int i = 9;i>0;i--){
            uf.union(2,4);
            uf.union(2,3);
        }
        println("id = "+ Arrays.toString(uf.getId()));
    }
}