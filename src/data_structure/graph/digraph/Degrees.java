package data_structure.graph.digraph;

import edu.princeton.cs.algs4.Bag;

/**
 * 4.2.7题目
 */
public class Degrees {

    /**原始图*/
    private Digraph G;

    /**原始图的反向图，用来计算入度*/
    private Digraph rG;

    public Degrees(Digraph G){
        this.G = G;
        this.rG = G.reverse();
    }

    /**计算v的入度*/
    public int indegree(int v) {
        //v的入度就是反向图的出度
        return countEdge(rG,v);
    }

    /**计算一个图中给定顶点的出度*/
    private int countEdge(Digraph d,int v){
            int count = 0;
            for(int w : d.adj(v)){
                count++;
            }
            return count;
    }

    /**计算给定顶点的出度*/
    public int outdegree(int v){
        return countEdge(G,v);
    }

    /**
     * 所有起点的集合
     * 起点即为入度为0的顶点
     * */
    public Iterable<Integer> sources(){
        Bag<Integer> bag = new Bag<>();
        for(int i = 0;i<G.V();i++){
            if (indegree(i) == 0) {
                bag.add(i);
            }
        }
        return bag;
    }

    /**
     * 所有终点的集合
     * 终点即为出度为0的点
     * */
    public Iterable<Integer> sinks(){
        Bag<Integer> bag = new Bag<>();
        for(int i = 0;i<G.V();i++){
            if (outdegree(i) == 0) {
                bag.add(i);
            }
        }
        return bag;
    }

    /**
     * 判断给定的图是否为映射
     * 如果每个顶点的出度均为1则称为映射
     * */
    public boolean isMap(){
        for(int v = 0;v < G.V();v++){
            if(outdegree(v) != 1){
                return false;
            }
        }
        return true;
    }
}
