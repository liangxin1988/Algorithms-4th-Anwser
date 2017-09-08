package Answer.chapter4.section2;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_15 extends Answer0 {
    @Override
    public void answer() {
        println("强连通分量要求若v -> w的路径存在，那么肯定也存在w -> v的路径，这样就会形成环。所以在有向无环图中不存在这样的强连通分量。但是由于规定了所有顶点与自身是强连通的，所以强连通分量是所有顶点。");
    }
}
