package algorithms.uf;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 实现带有路径压缩的quick-union算法
 */
public class CompressionQuickUnionUF extends QuickUnionUF {
    public CompressionQuickUnionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        //通过递归的形式进行路径压缩
        if(id[p] != p){
            id[p] = find(id[p]);
        }
        return id[p];
    }
}
