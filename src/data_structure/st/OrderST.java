package data_structure.st;

/**
 * 有序符号表的api接口。所有有序符号表要实现这个接口
 */
public interface OrderST<Key extends Comparable<Key>,Value> extends ST<Key,Value> {

    /**获取符号表中的最小键*/
    Key min();

    /**获取符号表中的最大键*/
    Key max();

    /**小于等于给定键的最大键*/
    Key floor(Key key);

    /**大于等于给定键的最小建*/
    Key ceiling(Key key);

    /**小于key的键的数量*/
    int rank(Key key);

    /**排名为k的键*/
    Key select(int k);

    /**删除最小的键*/
    void deleteMin();

    /**删除最大的键*/
    void deleteMax();

    /**判断给定范围（包括start和end）之间键的数量*/
    int size(Key start, Key end);

    /**获取给定范围（包括start和end）之间的键的集合，并按排序结果遍历*/
    Iterable<Key> keys(Key start, Key end);
}
