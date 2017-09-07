package Answer.chapter4.section2;

import Answer.base.Answer0;
import data_structure.graph.digraph.Digraph;
import edu.princeton.cs.algs4.In;
import util.FileUtil;
import util.TestFileConfig;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_5 extends Answer0 {
    @Override
    public void answer() {
        Digraph digraph = new Digraph(new In(FileUtil.getScanner(TestFileConfig.TINYG)));
        println(digraph.E());
        digraph.addEdge(0,1);  //尝试添加平行边
        digraph.addEdge(0,0);  //尝试添加自环
        println(digraph.E());
    }
}