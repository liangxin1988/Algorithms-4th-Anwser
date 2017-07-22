package data_structure.linked;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 前移编码
 * 1.3.40
 */
public class MoveToFront<Item extends Comparable<Item>> implements Iterable<Item> {

    private Node first;

    public void insert(Item item){
        first = new Node(item,first);   //添加item到表头
        for(Node index = first;index != null && index.next != null;index = index.next){
            if(index.next.item.compareTo(item) == 0){
                index.next = index.next.next;
                return;  //使用这种策略，就可能有重复数据，找到一个即可退出循环
            }
        }

    }

    @Override
    public Iterator<Item> iterator() {
        return new MoveToFrontIterator();
    }

    private class MoveToFrontIterator implements Iterator<Item>{

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

    private class Node{
        Item item;
        Node next;

        public Node(Item item){
            this.item = item;
        }

        public Node(Item item,Node next){
            this(item);
            this.next = next;
        }
    }

    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }
}
