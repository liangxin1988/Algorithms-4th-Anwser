package Answer.chapter4.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_1 extends Answer0 {
    @Override
    public void answer() {
        println("问题1:");
        println("2个顶点形成的图只能有一条边。之后每增加一个顶点，增加的边数为n-1(n为增加顶点后的总顶点数，因为每增加一个顶点，这个顶点可以跟除了这个顶点以外的所有点连成新边)。");
        println("如3个顶点边数比2个顶点多2条，4个顶点的边数比3个顶点边数增加3...");
        println("所以，n个顶点的总边数比n-1的边数多n-1条。经过计算可知总边数为n(n-1)/2");

        println("问题2:");
        println("含有V个顶点，含有最少边的情况就是他们形成一颗树的情况。");
        println("根据树的定义，含有V个结点的树，共有V-1条边（除根节点，每个节点都有一条边与其父节点相连.）");
    }
}
