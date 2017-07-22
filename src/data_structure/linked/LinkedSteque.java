package data_structure.linked;

/*
*  Steque的API
* -----------------------------------------------------------------
* public class Steque<Item>
* -----------------------------------------------------------------
*           Steque()            构造steque
*  boolean  isEmpty()           判断steque是否为空
*      int  size()              获取steque中元素个数
*     void  push(Item item)     将元素入栈（从顶部）
*     Item  pop()               将元素出栈（从顶部）
*     void  enqueue(Item itme)  将元素入列(从底部)
* -----------------------------------------------------------------
* */

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 基于链表的Steque实现
 * 题目1.3.32
 * */
public class LinkedSteque<Item> implements Iterable<Item>{

    private Node first;  //用最简单的实现，仅保留一个first
    private int count;  //对元素个数计数

    /**从尾部插入元素，类似入列*/
    public void enqueue(Item item){
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

    /**
     * 在Steque的头部插入数据（类似入栈）
     * */
    public void push(Item item){
        first = new Node(item,first);
        count++;
    }

    /**在Steque的头部弹出元素（类似出栈）*/
    public Item pop(){
        if(isEmpty()){
            throw new RuntimeException("空Steque不能pop");
        }
        Item item = first.item;
        first = first.next;
        count--;
        return item;
    }

    /**Steque是否为空*/
    public boolean isEmpty(){
        return count == 0;
    }
    /**获取Steque中的元素个数*/
    public int size(){
        return count;
    }

    private class Node{
        private Item item;
        private Node next;
        Node(Item item){
            this.item = item;
        }
        Node(Item item,Node next){
            this(item);
            this.next = next;
        }
    }

    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStequeIterator();
    }

    /**链表通用的遍历器*/
    private class LinkedStequeIterator implements Iterator<Item>{

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
}
