package algorithms.uf;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 实现quick-union算法
 * 题目1.5.2。
 */
public class QuickUnionUF extends UF{

    public long getC() {
        return c;
    }

    protected long c = 0;

    public QuickUnionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        c++;
        while(p != id[p]){
            c++;
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

        c++;
        id[j] = i;  //让i变成新的节点

        count--;
    }
}
