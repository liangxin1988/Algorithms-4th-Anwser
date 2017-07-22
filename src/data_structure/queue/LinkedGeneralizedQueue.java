package data_structure.queue;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 删除第k个元素
 * 1.3.38
 */
public class LinkedGeneralizedQueue<Item> implements GeneralizedQueue<Item> {

    private Node first;
    private int count = 0;

    @Override
    public void insert(Item item) {
        count++;
        if(first == null){
            first = new Node(item);
            return;
        }
        for(Node index = first;index != null;index = index.next){
            if(index.next == null){
                index.next = new Node(item);
                return;
            }
        }
    }

    @Override
    public Item delete(int k) {
        if(k < 0 || k >= count){
            throw new RuntimeException("Index不合法");
        }
        Item item = null;
        if(k == 0){
            item = first.item;
            first = first.next;
        }else{
            Node preNode = first;
            for(int i = 1;i<k;i++){
                preNode = preNode.next;
            }
            item = preNode.next.item;
            preNode.next = preNode.next.next;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedGeneralizedQueueIterator();
    }

    private class LinkedGeneralizedQueueIterator implements Iterator<Item>{

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }
    }

    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }


    @Override
    public boolean isEmpty() {
        return count == 0;
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
