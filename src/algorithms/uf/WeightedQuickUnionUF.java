package algorithms.uf;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class WeightedQuickUnionUF extends QuickUnionUF {

    public int[] getSz() {
        return sz;
    }

    private int[] sz;
    private int tc = 0;

    public WeightedQuickUnionUF(int N) {
        super(N);
        sz = new int[N];
        for(int i = 0;i<N;i++){
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j){
            return;
        }

        tc+=2;
        if(sz[i] < sz[j]){
            c++;
            id[i] = j;
            tc+=2;
            sz[j] += sz[i];
        }else{
            c++;
            id[j] = i;
            tc+=2;
            sz[i] += sz[j];
        }

        count--;
    }

    public int getTc() {
        return tc;
    }

}
