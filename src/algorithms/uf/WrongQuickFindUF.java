package algorithms.uf;

/**
 * !!!题目1.5.8中给出的错误示例
 */
public class WrongQuickFindUF extends QuickFindUF{
    public WrongQuickFindUF(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        if(connected(p,q)) return;
        for(int i = 0;i<id.length;i++)
            if(id[i] == id[p]) id[i] = id[q];
        count--;
    }
}
