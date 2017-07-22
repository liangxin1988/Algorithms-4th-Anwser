package Answer.chapter1.section5;

import Answer.base.Answer0;
import algorithms.uf.WeightedQuickUnionUF;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_4 extends Answer0 {
    @Override
    public void answer() {
        int a[] = {4,3,6,9,2,8,5,7,6,1,6};
        int b[] = {3,8,5,4,1,9,0,2,1,0,7};

        int c[] = {0,2,4,6,0,4,0};
        int d[] = {1,3,5,7,2,6,4};

        println("测试对照输入：");
        WeightedQuickUnionUF uf1 = new WeightedQuickUnionUF(10);
        for(int i = 0;i<a.length;i++){
            println("union:"+a[i]+","+b[i]);
            uf1.union(a[i],b[i]);
            println("id[] = "+ Arrays.toString(uf1.getId())+",sz[] = "+Arrays.toString(uf1.getSz())+",操作数组次数："+(uf1.getTc() + uf1.getC()));
        }

        println("测试最坏输入：");
        WeightedQuickUnionUF uf2 = new WeightedQuickUnionUF(10);
        for(int i = 0;i<c.length;i++){
            println("union:"+c[i]+","+d[i]);
            uf2.union(c[i],d[i]);
            println("id[] = "+ Arrays.toString(uf2.getId())+",sz[] = "+Arrays.toString(uf2.getSz())+",操作数组次数："+(uf2.getTc() + uf2.getC()));
        }
    }
}