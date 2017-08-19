package data_structure.st;

/**
 * 标准的符号表API.所有的符号表都要实现这个接口
 */
public interface ST<Key,Value> {

    /**插入键值对*/
    void put(Key key, Value value);

    /**获取键对应的值*/
    Value get(Key key);

    /**通过键删除键值对*/
    void delete(Key key);

    /**判断符号表中是否存在给定的键*/
    boolean contains(Key key);

    /**判断符号表是否为空*/
    boolean isEmpty();

    /**获取符号表中键值对的个数*/
    int size();

    /**给定所有键的集合，用来遍历符号表*/
    Iterable<Key> keys();
}
