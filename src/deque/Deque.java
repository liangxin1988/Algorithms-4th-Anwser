package deque;

/**
 * 双向队列的接口
 */
public interface Deque<Item> extends Iterable<Item> {

    /**判断双向队列是否为空*/
    boolean isEmpty();

    /**获取双向队列中的元素个数*/
    int size();

    /**向左端添加元素*/
    void pushLeft(Item item);

    /**向右端添加元素*/
    void pushRight(Item item);

    /**从左边删除一个元素*/
    Item popLeft();

    /**从右边删除一个元素*/
    Item popRight();
}
