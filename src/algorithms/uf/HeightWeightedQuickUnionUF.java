package algorithms.uf;

/**
 * 通过树的高度实现带权重的quick-union算法
 * 1.5.14
 */
public class HeightWeightedQuickUnionUF extends UF {

    /**用来保存每棵树的高度*/
    private int[] height;

    public HeightWeightedQuickUnionUF(int N) {
        super(N);
        height = new int[N];
    }

    @Override
    public int find(int p) {
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j){
            return;
        }

        if(height[i] > height[j]){
            //i比j高
            id[j] = i;  //将j树连接到i的根节点上
            height[i] = height[j] + 1 > height[i] ? height[j] + 1 : height[i];  //更新i树的高度。j树连接到i树以后，所有节点的高度都+1。
        }else{
            id[i] = j;
            height[j] = height[i] + 1 > height[j] ? height[i] + 1 : height[j];
        }
        count--;
    }
}
