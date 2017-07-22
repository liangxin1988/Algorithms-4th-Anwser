package data_structure.queue;

/**
 * 定义一个队列接口
 */
public interface Queue<Item> extends Iterable<Item> {
    /**入列*/
    void enqueue(Item item);

    /**出列*/
    Item dequeue();

    /**判断队列是否为空*/
    boolean isEmpty();

    /**获取队列中元素的个数*/
    int size();
}
