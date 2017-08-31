package data_structure.graph;

import algorithms.uf.IUF;

/**
 * 通过union-find算法实现图搜索
 */
public class UnionFindGraphSearch extends GraphSearch implements IUF {

    /**union-find算法中使用这个数组保存每个元素对应的连通分量id*/
    private int[] id;

    /**连通分量的初始个数*/
    private int count;

    /**用来保存树元素个数*/
    private int[] size;

    /**判断给定的两个元素是否连同*/
    public boolean connected(int w,int v){
        return find(w) == find(v);
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        //已经是一个分量中的，不需要链接
        if(pId == qId){
            return;
        }

        if(size[pId] > size[qId]){
            id[qId] = pId;
            size[pId] = size[pId] + size[qId];
        }else{
            id[pId] = qId;
            size[qId] = size[pId] + size[qId];;
        }
        count--;
    }

    /**获取给定元素的连同分量的id*/
    public int find(int v){
        while(id[v] != v){
            v = id[v];
        }
        return v;
    }

    private void init(){
        //遍历所有边，使具有边的两个点在union-find算法中进行连通。
        for(int v = 0;v < graph.V();v++){
            for(int w : graph.adj(v)){
                union(v,w);
            }
        }
    }

    public UnionFindGraphSearch(Graph graph, int s) {
        super(graph, s);
        id = new int[graph.V()];
        count = id.length;
        //初始状态下，为每一个元素分配不同的id。
        for(int i = 0;i<count;i++){
            id[i] = i;
        }
        size = new int[count];
        for(int i = 0;i<count;i++){
            size[i] = 1;
        }
        init();
    }


    @Override
    public boolean marked(int v) {
        //如果给定点和起点的联通分量ID一致，则说明两者连同
        return find(v) == find(s);
    }

    @Override
    public int count() {
        //由于union-find中的size保存的是连通分量表示的树的大小，其含义恰好为与s连通的分量的个数
        return size[find(s)];
    }
}
