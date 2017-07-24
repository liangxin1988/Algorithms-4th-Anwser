package Answer.chapter1.section5;

import Answer.base.Answer0;
import algorithms.uf.CompressionQuickUnionUF;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_12 extends Answer0 {
    @Override
    public void answer() {
        CompressionQuickUnionUF uf = new CompressionQuickUnionUF(5);
        int[] a = new int[]{1,0,3,3};
        int[] b = new int[]{2,1,4,0};
        for(int i = 0;i<a.length;i++){
            uf.union(a[i],b[i]);
        }
        println(Arrays.toString(uf.getId()));
    }
}
