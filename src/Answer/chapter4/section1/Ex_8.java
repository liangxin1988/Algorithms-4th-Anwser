package Answer.chapter4.section1;

import Answer.base.Answer0;
import Answer.base.Answer1Integer;
import Answer.base.Answer1String;
import data_structure.graph.Graph;
import data_structure.graph.UnionFindGraphSearch;
import edu.princeton.cs.algs4.In;
import util.FileUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_8 extends Answer1Integer {
    @Override
    public void answer() {
        Graph graph = new Graph(new In(FileUtil.getScanner("tinyG.txt")));
        int s = getArgs1();
        UnionFindGraphSearch search = new UnionFindGraphSearch(graph,s);
        for(int v = 0;v < graph.V();v++){
            if(search.marked(v)) print(v + " ");
        }
        println();
        println("与"+s+"连通的顶点有"+search.count()+"个");
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{0};
    }
}
