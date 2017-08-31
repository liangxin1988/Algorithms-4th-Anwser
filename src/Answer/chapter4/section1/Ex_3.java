package Answer.chapter4.section1;

import Answer.base.Answer0;
import data_structure.graph.Graph;
import edu.princeton.cs.algs4.In;
import util.FileUtil;

import java.io.FileNotFoundException;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_3 extends Answer0 {
    @Override
    public void answer() {
        try {
            Graph graph = new Graph(new In(FileUtil.getScanner("tinyG.txt")));
            Graph graph2 = new Graph(graph);

            println("v = "+graph2.V()+",e = "+graph2.E());
            for(int i = 0;i<graph2.V();i++){
                print("i = "+i+": ");
                for(int x : graph2.adj(i)){
                    print(x + " ");
                }
                println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
