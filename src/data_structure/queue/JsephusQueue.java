package data_structure.queue;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * jsephus队列。
 * 为了便于批量移动元素，决定底层使用单向链表实现。
 * 循环列表实现起来更简单，可以尝试去实现
 * 1.3.37
 */
public class JsephusQueue<Item> implements Queue<Item> {

    private Node first,last;
    private int count = 0;

    /**报的数*/
    private int M;

    /**构造一个队列，并设置报数的M*/
    public JsephusQueue(int M){
        this.M = M;
    }

    @Override
    public void enqueue(Item item) {
        count++;
        if(last == null){
            last = first = new Node(item);
            return;
        }
        last.next = new Node(item);
        last = last.next;
    }

    /**
     * 将队列中前n个移动到队列尾部
     * 如果n大于队列元素个数，则取余后移动
     * */
    private void moveN(int n){
        if(count == 0){
            throw new RuntimeException("没有元素，无法移动");
        }
        n %= count;
        if(n <= 0){  //负数和0不管
            return;
        }
        //找到第n个节点，移动后，该节点为新的last
        Node index = first;
        for(int i = 1;i<n;i++){
            index = index.next;
        }
        //开始移动
        last.next = first;
        last = index;
        first = index.next;
    }

    @Override
    public Item dequeue() {
        moveN(M - 1);  //先移动M - 1个人，那么报M的人变成了新的first。
        Item item = first.item;
        first = first.next;  //将报M的人出栈（杀死）.
        if(first == null){
            last = null;
        }
        count--;
        return item;
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
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }

    @Override
    public Iterator<Item> iterator() {
        return new JsephusQueueIterator();
    }

    private class JsephusQueueIterator implements Iterator<Item>{

        Node index = first;

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

    class Node{
        private Item item;
        private Node next;

        public Node(Item item){
            this.item = item;
        }

        public Node(Item item,Node next){
            this(item);
            this.next = next;
        }
    }
}
