package Answer.chapter4.section2;

import Answer.base.Answer0;
import data_structure.graph.digraph.Digraph;
import edu.princeton.cs.algs4.In;
import util.FileUtil;
import util.TestFileConfig;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_4 extends Answer0 {
    @Override
    public void answer() {
        Digraph digraph = new Digraph(new In(FileUtil.getScanner(TestFileConfig.TINYG)));

        for(int i = 0;i<digraph.V();i++){
            for(int j = 0;j<digraph.V();j++){
                if(digraph.hasEdge(i,j)){
                    println(i + " --> "+j);
                }
            }
        }
    }
}