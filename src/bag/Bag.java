package bag;

/**
 * 背包的接口
 */
public interface Bag<Item> extends Iterable<Item> {
    /**添加一个元素*/
    void add(Item item);

    /**判断背包是否为空*/
    boolean isEmpty();

    /**获取背包中元素个数*/
    int size();
}
