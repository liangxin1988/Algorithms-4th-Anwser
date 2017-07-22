package data_structure.stack;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 链表实现的栈
 * 1.3.42
 */
public class LinkedStack<Item> implements Stack<Item> {

    private Node first;
    private int count;

    public LinkedStack(LinkedStack linkedStack){
        if(linkedStack.size() == 0){
            return;
        }
        Node curr = null;
        for(Node index = linkedStack.first;index != null;index = index.next){
            if(curr == null){
                curr = first = new Node(index.item);
            }else{
                curr = curr.next = new Node(index.item);
            }
            count++;
        }
    }

    @Override
    public void push(Item item) {
        first = new Node(item,first);
        count++;
    }

    @Override
    public Item pop() {
        if(isEmpty()){
            throw new RuntimeException("空栈不能出栈");
        }
        count--;
        Item item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    /**链表通用的遍历器*/
    private class LinkedStackIterator implements Iterator<Item>{

        private Node index = first;

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public Item next() {
            Item item = index.item;
            index = index.next;
            return item;
        }
    }
    /**
     * 链表中的节点
     * */
    private class Node{
        private Item item;
        private Node next;

        //构造函数为了简化对链表的操作。
        Node(Item item){
            this.item = item;
        }
        Node(Item item, Node next){
            this(item);
            this.next = next;
        }
    }

    public LinkedStack(){

    }
}
