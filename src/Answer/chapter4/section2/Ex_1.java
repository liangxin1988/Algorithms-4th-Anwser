package Answer.chapter4.section2;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_1 extends Answer0 {
    @Override
    public void answer() {
        println("含有V个顶点。每个顶点都有指向所有其他顶点的有向边，边的总个数为V(V-1)。");
        println("如果V是偶数，那么需要V/2条有向边，将顶点2个一组，每组使用一条有向边相连。如果V是奇数，那么需要额外的一条边将单独的顶点与其他任意一个顶点相连");
    }
}