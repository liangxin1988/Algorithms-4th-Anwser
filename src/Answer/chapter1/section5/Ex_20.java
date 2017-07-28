package Answer.chapter1.section5;

import Answer.base.Answer0;
import algorithms.uf.QuickFindUF;
import algorithms.uf.ResizingArrayWeightedQuickUnionUF;
import framework.Fixme;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

@Fixme(info = "对newSite()的功能没理解")
public class Ex_20 extends Answer0 {
    @Override
    public void answer() {
        //使用两个数组表示题目中给出的测试用例
        int[] a = {9,3,5,7,2,5,0,4,};
        int[] b = {0,4,8,2,1,7,3,2,};

        ResizingArrayWeightedQuickUnionUF uf = new ResizingArrayWeightedQuickUnionUF();  //动态变化的UF算法，不需要指定初始的链接个数
        for(int i = 0;i<a.length;i++){
            uf.union(a[i],b[i]);
        }
        println("链接个数："+uf.count());
    }
}