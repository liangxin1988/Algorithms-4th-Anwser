package data_structure.queue;

import data_structure.linked.SimpleLinked;

import java.util.Iterator;

/**
 * 链表实现的队列
 */
public class LinkedQueue<T> implements Queue<T>{

    private Node first;
    private int count = 0;

    @Override
    public void enqueue(T t) {
        count++;
        first = new Node(t,first);
    }

    @Override
    public T dequeue() {
        if(count == 0){
            throw new RuntimeException("空队列不能出列");
        }
        if(count == 1){
            count--;
            T result = first.item;
            first = null;
            return result;
        }
        count--;
        Node index;
        for(index = first;index.next.next != null;index = index.next);
        T result = index.next.item;
        index.next = null;
        return result;
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
    public Iterator<T> iterator() {
        return new SimpleListIterator();
    }

    /**链表通用的遍历器*/
    private class SimpleListIterator implements Iterator<T>{

        private Node index = first;

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public T next() {
            T item = index.item;
            index = index.next;
            return item;
        }
    }

    private class Node{
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
