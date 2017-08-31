package data_structure.graph;

/**
 * 图的离心率
 */
public class GraphProperties {

    private Graph g;

    /**保存所有顶点的离心率*/
    private int[] eccentricity;

    /**保存离心率的直径和半径，也就是最大离心率和最小离心率*/
    private int diameter = Integer.MIN_VALUE,radius = Integer.MAX_VALUE;

    public GraphProperties(Graph g){
        this.g = g;
        eccentricity = new int[g.V()];
        BreadthFirstPaths breadthFirstPaths;
        for(int v = 0;v < g.V();v++){
            breadthFirstPaths = new BreadthFirstPaths(g,v);
            int max = Integer.MIN_VALUE;
            for(int w = 0;w < g.V();w++){
                if(v != w){
                    int dest = breadthFirstPaths.distTo(w);
                    if(dest > max){
                        max = dest;
                    }
                }
            }
            eccentricity[v] = max;
            if(max < radius){
                radius = max;
            }
            if(max > diameter){
                diameter = max;
            }
        }
    }

    /**
     * 获取顶点V的离心率
     * 离心率是它和离它最远的顶点的最短距离
     * */
    public int eccentricity(int v){
        return eccentricity[v];
    }

    /**
     * 获取图的直径
     * 所有顶点的最大离心率
     * */

    public int diameter(){
        return diameter;
    }

    /**
     * 获取图的半径
     * 所有顶点的最小离心率
     * */
    public int radius(){
        return  radius;
    }

    /**
     * 获取图的一个中点
     * 中点为离心率和半径相等的顶点
     * */
    public int center(){
        for(int x : eccentricity){
            if(x == radius){
                return x;
            }
        }
        return -1;
    }
}
