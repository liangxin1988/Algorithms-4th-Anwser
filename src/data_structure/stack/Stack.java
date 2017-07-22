package data_structure.stack;

/**
 * Created by liangxin on 2017/7/4.
 */
public interface Stack<Item> extends Iterable<Item> {
    /**将一个元素压栈*/
    void push(Item item);
    /**删除最近入栈的元素*/
    Item pop();
    /**	判断栈是否为空*/
    boolean isEmpty();
    /**获取栈中元素个数*/
    int size();
}
