package algorithms.uf;
/**
 * 用来演示union-find算法的类
 * */
public abstract class UF implements IUF{

    protected int[] id;

    protected int count;

    public UF(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i<N;i++){
            id[i] = i;
        }
    }

    @Override
    public int count(){
        return count;
    }

    @Override
    public boolean connected(int p,int q) {
        return find(p) == find(q);
    }

    @Override
    public abstract int find(int p);

    @Override
    public abstract void union(int p,int q);
}
