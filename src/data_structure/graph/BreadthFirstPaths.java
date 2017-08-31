package data_structure.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * 广度优先搜索路径
 */
public class BreadthFirstPaths extends GraphPath{

    /**同深度优先算法一样，广度优先算法也要求标记以检查过的点*/
    private boolean[] mark;

    private int[] distTo;

    /**同深度优先算法一样，广度优先算法也是用数组保存父节点的方式保存路径*/
    private int[] path;

    public BreadthFirstPaths(Graph g, int s) {
        super(g, s);
        int v = g.V();
        mark = new boolean[v];
        path = new int[v];
        distTo = new int[v];
        bfs(g,s);
    }

    /**通过广度优先算法遍历树，并查找对应的点*/
    private void bfs(Graph g,int point){
        Queue<Integer> queue = new Queue<>();
        mark[point] = true;
        distTo[point] = 0;
        queue.enqueue(point);
        while(!queue.isEmpty()){
            Integer i = queue.dequeue();
            for(int cache : g.adj(i)){
                if(!mark[cache]){
                    path[cache] = i;
                    queue.enqueue(cache);
                    mark[cache] = true;
                    distTo[cache] = distTo[path[cache]] + 1;
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return mark[v];
    }
    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for(int x = v;x != s;x = path[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public int distTo(int v){
        return distTo[v];
    }
}
