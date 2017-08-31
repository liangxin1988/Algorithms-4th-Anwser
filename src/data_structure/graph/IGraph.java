package data_structure.graph;

/**
 * 图的抽象接口
 */
public interface IGraph {
    /**返回图的顶点个数*/
    int V();

    /**返回图的边的个数*/
    int E();

    /**添加一条连接v和w的边*/
    void addEdge(int v, int w);

    /**返回一个遍历器，用来遍历和v相邻的所有顶点*/
    Iterable<Integer> adj(int v);
}
