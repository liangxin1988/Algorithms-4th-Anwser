package data_structure.graph;

/**
 * 表示对无向图搜索的API
 */
public abstract class GraphSearch {

    /**要处理的图*/
    protected Graph graph;

    /**搜索的起点*/
    protected int s;

    public GraphSearch(Graph graph, int s){
        this.graph = graph;
        this.s = s;
    }

    /**给定点与起点s是否连同*/
    public abstract boolean marked(int v);

    /**与起点s连同的点的数量*/
    public abstract int count();
}
