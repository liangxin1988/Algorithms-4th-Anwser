package Answer.chapter1.section5;

import Answer.base.Answer0;
import algorithms.uf.CompressionQuickUnionUF;
import algorithms.uf.CompressionWeightedQuickUnionUF;
import algorithms.uf.QuickUnionUF;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_13 extends Answer0 {
    @Override
    public void answer() {
        QuickUnionUF uf = new CompressionWeightedQuickUnionUF(8);
        int[] a = new int[]{0,2,0,4,6,4,4,};
        int[] b = new int[]{1,3,2,5,7,6,0,};
        for(int i = 0;i<a.length;i++){
            uf.union(a[i],b[i]);
        }
        println(Arrays.toString(uf.getId()));
    }
}