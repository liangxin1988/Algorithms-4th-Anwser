package Answer.chapter4.section1;

import Answer.base.Answer0;
import data_structure.graph.BreadthFirstPaths;
import data_structure.graph.Graph;
import data_structure.graph.GraphPath;
import edu.princeton.cs.algs4.In;
import util.FileUtil;
import util.TestFileConfig;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_13 extends Answer0 {
    @Override
    public void answer() {
        Graph g = new Graph(new In(FileUtil.getScanner(TestFileConfig.TINYG)));
        BreadthFirstPaths path = new BreadthFirstPaths(g,0);
        for(int i = 0;i<g.V();i++){
            println(i+"最短路径长度为："+path.distTo(i));
        }
    }
}
