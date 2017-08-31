package Answer.chapter4.section1;

import Answer.base.Answer0;
import data_structure.graph.Graph;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_5 extends Answer0 {
    @Override
    public void answer() {
        Graph graph = new Graph(5);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);

        println("e = "+graph.E());
        graph.addEdge(2,2);  //尝试添加闭环
        println("e = "+graph.E());
        graph.addEdge(3,2);  //尝试添加平行边
        println("e = "+graph.E());
    }
}
