package data_structure.max_pq;

/**
 * 优先队列的抽象实现，扩展了优先队列的构造方法，和isempyt的默认实现
 */
abstract public class AbsMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**判断元素的大小关系*/
    protected boolean less(Key a,Key b){
        return a.compareTo(b) < 0;
    }

    /**交换数组中两个元素的位置*/
    protected void exch(Key[] a,int i,int j){
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
