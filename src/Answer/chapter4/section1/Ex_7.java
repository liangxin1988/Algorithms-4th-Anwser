package Answer.chapter4.section1;

import Answer.base.Answer0;
import Answer.base.Answer1String;
import data_structure.graph.Graph;
import edu.princeton.cs.algs4.In;
import util.FileUtil;

import static edu.princeton.cs.algs4.StdOut.println;


/**
 */
public class Ex_7 extends Answer1String {
    @Override
    public void answer() {
        String filename = getArgs1();
        Graph graph = new Graph(new In(FileUtil.getScanner(filename)));
        println(graph);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"tinyG.txt"};
    }
}
