package Answer.chapter1.section5;

import Answer.base.Answer0;
import algorithms.uf.IUF;
import algorithms.uf.QuickUnionUF;
import algorithms.uf.WeightedQuickUnionUF;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_3 extends Answer0 {
    @Override
    public void answer() {
        //使用两个数组表示题目中给出的测试用例
        int[] a = {9,3,5,7,2,5,0,4,};
        int[] b = {0,4,8,2,1,7,3,2,};

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        for(int i = 0;i<a.length;i++){
            println("union:"+a[i]+","+b[i]);
            uf.union(a[i],b[i]);
            println("id[] = "+ Arrays.toString(uf.getId())+",操作数组次数："+(uf.getTc() + uf.getC()));
        }
    }
}