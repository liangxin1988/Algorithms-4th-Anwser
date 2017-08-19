package data_structure.st;

import java.util.Iterator;

/**
 * 基于无序链表实现的符号表
 */
public class SequentialSearchST<Key,Value> extends AbsST<Key,Value> {

    private Node first;
    private int count;

    @Override
    public void delete(Key key) {
        if(first == null){
            throw new RuntimeException("空符号表不能删除");
        }
        if(first.key.equals(key)){
            first = first.next;
            count--;
            return;
        }
        for(Node index = first;index.next != null;index = index.next){
            if(index.next.key.equals(key)){
                index.next = index.next.next;
                count--;
                return;
            }
        }
    }

    @Override
    public void put(Key key, Value value) {
        if(value == null){
            delete(key);
            return;
        }
        for(Node index = first;index != null;index = index.next){
            if(index.key.equals(key)){
                index.value = value;
                return;
            }
        }
        first = new Node(key,value,first);
        count++;
    }

    @Override
    public Value get(Key key) {
        for(Node index = first;index != null;index = index.next){
            if(index.key.equals(key)){
                return index.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterable<Key> keys() {
        return new SequentialSearchSTKeys();
    }

    private class SequentialSearchSTKeys implements Iterable<Key>{

        @Override
        public Iterator<Key> iterator() {
            return new SequentialSearchSTKeysIterator();
        }
    }

    private class SequentialSearchSTKeysIterator implements Iterator<Key>{

        private Node index = first;

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public Key next() {
            Key key = index.key;
            index = index.next;
            return key;
        }
    }

    /**节点*/
    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value,Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
