package Answer.chapter4.section2;

import Answer.base.Answer0;
import data_structure.graph.digraph.Digraph;
import edu.princeton.cs.algs4.In;
import util.FileUtil;
import util.TestFileConfig;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_3 extends Answer0{
    @Override
    public void answer() {
        Digraph digraph = new Digraph(new In(FileUtil.getScanner(TestFileConfig.TINYG)));

        Digraph d = new Digraph(digraph);
        println(d);
    }
}
