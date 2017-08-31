package Answer.chapter4.section1;

import Answer.base.Answer0;
import data_structure.graph.Graph;
import edu.princeton.cs.algs4.In;
import util.FileUtil;
import util.TestFileConfig;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_15 extends Answer0 {
    @Override
    public void answer() {
        Graph graph = new Graph(new In(FileUtil.getScanner(TestFileConfig.TINYG_ADJ)));
        println(graph);
    }
}