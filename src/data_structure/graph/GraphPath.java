package data_structure.graph;

/**
 * 用于查找路径的算法
 */
public abstract class GraphPath {
    /**待搜索的图*/
    protected Graph g;
    /**搜索起点*/
    protected int s;

    public GraphPath(Graph g,int s){
        this.g = g;
        this.s = s;
    }

    /**判断起点到给定点是否有路劲*/
    public abstract boolean hasPathTo(int v);

    /**返回起点到给定点的路径。如果没有则返回Null
     **/
    public abstract Iterable<Integer> pathTo(int v);
}
