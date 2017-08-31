package Answer.chapter4.section1;

import Answer.base.Answer0;
import data_structure.graph.Graph;
import edu.princeton.cs.algs4.In;
import util.FileUtil;

import java.io.FileNotFoundException;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_4 extends Answer0 {
    @Override
    public void answer() {
        Graph graph = new Graph(new In(FileUtil.getScanner("tinyG.txt")));
        for(int i = 0;i<graph.V();i++){
            for(int j = 0;j<graph.V();j++){
                if(graph.hasEdge(i,j)){
                    println(i + "与" + j + "相连");
                }
            }
        }
    }
}
