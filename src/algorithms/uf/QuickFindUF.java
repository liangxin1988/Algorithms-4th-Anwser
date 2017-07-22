package algorithms.uf;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 用来演示quick-find算法
 * 1.5.1题。为了满足题目要求，增加了计算访问数组次数的计数器，且在union后打印id数组
 */
public class QuickFindUF extends UF {

    private long c = 0;

    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        c++;
        return id[p];  //id数组保存了连通分量的标识
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);  //分别找到p和q对应的连同分量标识
        int j = find(q);

        if(i == j){
            return;
        }

        for(int k = 0;k<id.length;k++){
            c++;
            if(id[k] == i){  //为了合并i和j的连通分量，将所有i分量的元素标识改为j。
                c++;
                id[k] = j;
            }
        }

        println("id[] = "+ Arrays.toString(id)+",操作数组次数："+c);
    }
}
