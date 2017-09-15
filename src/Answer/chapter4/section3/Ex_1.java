package Answer.chapter4.section3;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_1 extends Answer0{
    @Override
    public void answer() {
        println("对两个数字加上同样的正常数或乘以同样的正常数，其大小关系不变。");
        println("可推出，对于一个图中的所有边，都加上或者乘以同样的正常数，其所有边的权重不变。");
        println("顶点、边和权重都没有变化，最小生成树不会改变（权重除外）");
    }
}
