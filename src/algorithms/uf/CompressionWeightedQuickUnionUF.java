package algorithms.uf;

/**
 * 在加权quick-union基础上增加路径压缩的算法，其实就是修改find（）,与12题一致
 */
public class CompressionWeightedQuickUnionUF extends WeightedQuickUnionUF{

    public CompressionWeightedQuickUnionUF(int N) {
        super(N);
    }

    @Override
    /**1.5.12中使用了递归，这里尝试使用非递归实现相同的功能*/
    public int find(int p) {
        int cacheP = p;  //缓存p，等下还要使用
        int parent;
        while(id[cacheP] != cacheP){
            cacheP = id[cacheP];
        }
        parent = cacheP;  //先找到整条分支的根节点
        while(id[p] != p){  //重新遍历，这次遍历要同时修改父节点
            int myParent = id[p];  //缓存当前节点的父节点
            id[p] = cacheP;
            p = myParent;
        }
        return p;
    }
}
