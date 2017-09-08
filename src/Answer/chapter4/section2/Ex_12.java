package Answer.chapter4.section2;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_12 extends Answer0 {
    @Override
    public void answer() {
        println("所有的顶点对于自己都是可达的，所以传递闭包中应该包括V个自环");
        println("V-1条边形成一个简单路径，所以这个路径肯定包含了所有的V个顶点。那么传递闭包中，应该有(V-1) + (V-2) + …… + 1 = V(V-1)/2 条边（路径起点可以指向其他所有点，共有V-1条路径，路径上的第二个点可以指向除了起点和自身外的所有点，共有V-2条。。。）");
        println("综上，这幅图的传递闭包中共有(V + V^2)/2个边");
    }
}
