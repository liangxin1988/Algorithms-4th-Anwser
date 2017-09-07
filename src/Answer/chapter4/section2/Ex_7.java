package Answer.chapter4.section2;

import Answer.base.Answer0;
import data_structure.graph.digraph.Degrees;
import data_structure.graph.digraph.Digraph;
import edu.princeton.cs.algs4.In;
import util.ChapterUtil;
import util.FileUtil;
import util.TestFileConfig;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_7 extends Answer0 {
    @Override
    public void answer() {
        Digraph digraph = new Digraph(new In(FileUtil.getScanner(TestFileConfig.TINYG)));
        Degrees degrees = new Degrees(digraph);
        //测试入度
        println("入度：");
        for(int v = 0;v < digraph.V();v++){
            println("顶点"+v+"的入度为："+degrees.indegree(v));
        }
        //测试出度
        println("出度：");
        for(int v = 0;v < digraph.V();v++){
            println("顶点"+v+"的出度为："+degrees.outdegree(v));
        }
        //测试起点集合
        println("起点集合:");
        println(ChapterUtil.iterableToString(degrees.sources()));
        //测试终点集合
        println("终点集合:");
        println(ChapterUtil.iterableToString(degrees.sinks()));
        //测试是否映射
        println("图"+(degrees.isMap()?"是":"不是")+"映射");

        //构造一个映射进行测试
        int pointCount = 5;
        Digraph digraph1 = new Digraph(pointCount);
        for(int i = 0;i<pointCount;i++){
            int end = i + 1;
            if(end >= pointCount){
                end = 0;
            }
            digraph1.addEdge(i,end);
        }
        degrees = new Degrees(digraph1);
        //测试是否映射
        println("图"+(degrees.isMap()?"是":"不是")+"映射");
    }
}
