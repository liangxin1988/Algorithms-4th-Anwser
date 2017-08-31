package Answer.chapter4.section1;

import Answer.base.Answer0;
import data_structure.graph.Graph;
import data_structure.graph.GraphProperties;
import edu.princeton.cs.algs4.In;
import util.FileUtil;
import util.TestFileConfig;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_16 extends Answer0{
    @Override
    public void answer() {
        Graph g = new Graph(new In(FileUtil.getScanner(TestFileConfig.TINYG_ADJ)));

        GraphProperties properties = new GraphProperties(g);

        for(int v = 0;v < g.V();v++){
            println(v + ":" + properties.eccentricity(v));
        }
        println("diameter = "+properties.diameter());
        println("radius = "+properties.radius());
        println("center = "+properties.center());
    }
}
