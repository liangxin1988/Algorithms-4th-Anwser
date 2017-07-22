package algorithms.uf;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class WeightedQuickUnionUF extends QuickUnionUF {

    private int[] treeSize;
    private int tc = 0;

    public WeightedQuickUnionUF(int N) {
        super(N);
        treeSize = new int[N];
        for(int i = 0;i<N;i++){
            treeSize[i] = 1;
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
        if(treeSize[i] < treeSize[j]){
            c++;
            id[i] = j;
            tc+=2;
            treeSize[j] += treeSize[i];
        }else{
            c++;
            id[j] = i;
            tc+=2;
            treeSize[i] += treeSize[j];
        }

        count--;
    }

    public int getTc() {
        return tc;
    }

}
