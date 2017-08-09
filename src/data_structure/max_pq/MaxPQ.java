package data_structure.max_pq;

/**
 * 定义了优先队列需要实现的API
 */
public interface MaxPQ<Key extends Comparable<Key>> {

    /**向优先队列中插入一个元素*/
    void  insert(Key v);

    /**返回优先队列中的最大元素*/
    Key max();

    /**返回优先队列中的最大元素，并删除该元素*/
    Key delMax();

    /**判断优先队列是否为空*/
    boolean isEmpty();

    /**获取优先队列中元素的个数*/
    int size();
}
