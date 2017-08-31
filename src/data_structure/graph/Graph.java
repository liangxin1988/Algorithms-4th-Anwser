package data_structure.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * 通过邻接表实现一个无向图
 */
public class Graph implements IGraph{

    /**记录边的个数*/
    private int count;

    /**记录顶点的个数*/
    private int v;

    /**保存邻接表的数组。邻接表表示点的所有相邻的点*/
    private Bag<Integer>[] bags;

    public Graph(int v){
        this.v = v;
        bags = (Bag<Integer>[]) new Bag[v];
        for(int i = 0;i<bags.length;i++){
            bags[i] = new Bag<>();
        }
    }

    public Graph(In in){
        this(in.readInt());  //第一个int表示v的个数
        int e = in.readInt();  //第二个int表示边的个数
        for(int i = 0;i<e;i++){  //剩下的e对整数表示e条边
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public Graph(Graph g){
        //若希望复制一个类，只需要将类中的属性完全复制即可。
        this.v = g.v;
        this.count = g.count;
        //若希望对新图的操作不影响旧图，需要将数据进行复制
        this.bags = (Bag<Integer>[])new Bag[g.bags.length];
        //遍历旧图中的邻接表
        for(int i = 0;i<bags.length;i++){
            Bag<Integer> bag = new Bag<>();
            //将旧图的邻接表中的元素添加到新图的邻接表中
            for(int x : g.bags[i]){
                bag.add(x);
            }
            this.bags[i] = bag;
        }
    }

    @Override
    public int V() {
        return v;
    }

    @Override
    public int E() {
        return count;
    }

    @Override
    public void addEdge(int v, int w) {
        bags[v].add(w);
        bags[w].add(v);
        count++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return bags[v];
    }
}
