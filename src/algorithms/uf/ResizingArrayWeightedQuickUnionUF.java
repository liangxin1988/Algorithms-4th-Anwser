package algorithms.uf;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 使用动态数组
 */
public class ResizingArrayWeightedQuickUnionUF implements IUF {

    //与通用方案类似，使用数组id和treeSize保存父触点和当前树的尺寸
    private int[] id = new int[0];
    private int[] treeSize = new int[0];

    //类似原方案的count，不同的是这个值会随着输入变化。其含义为输入数字的最大值，真实的连通分量要在这个基础上加1（因为还有0）
    private int max_union = 0;
    //由于count会变，所以union调用的时候不能直接在count上操作，需要单独记录变量
    private int minusCount = 0;

    @Override
    public int find(int p){
        //通过路径压缩提升效率
        int cacheP = p;
        while(id[cacheP] != cacheP){
            cacheP = id[cacheP];
        }
        while(id[p] != p){
            int myParent = id[p];
            id[p] = cacheP;
            p = myParent;
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return max_union + 1 - minusCount;
    }

    private void reSize(int size){
        if(size > max_union){
            max_union = size;
        }
        if(size < id.length){
            return;
        }
        int[] cacheId = new int[size+1];  //使用size+1可以不浪费内存，但是会频繁创建新的数组。使用size * 2会减少创建数组花费的时间，但是会造成内存浪费
        int i = 0;
        for(i = 0;i<id.length;i++){
            cacheId[i] = id[i];
        }
        for(;i<cacheId.length;i++){
            cacheId[i] = i;
        }
        id = cacheId;

        int[] cacheSize = new int[size+1];
        for(i = 0;i<treeSize.length;i++){
            cacheSize[i] = treeSize[i];
        }
        treeSize = cacheSize;
    }

    @Override
    public void union(int p, int q) {
        int max = p > q ? p : q;
        reSize(max);

        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }

        if(treeSize[i] > treeSize[j]){
            id[j] = i;
            treeSize[i] += treeSize[j];
        }else{
            id[i] = j;
            treeSize[j] += treeSize[i];
        }
        minusCount++;
    }
}
