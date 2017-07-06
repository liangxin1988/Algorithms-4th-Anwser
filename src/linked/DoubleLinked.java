package linked;

import edu.princeton.cs.algs4.StdOut;
import util.ChapterUtil;

import java.util.Iterator;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 双向链表
 * 题目1.3.31
 */
public class DoubleLinked<Item> implements Iterable<Item> {

    private DoubleNode first;
    private DoubleNode last;

    /**从头部添加数据*/
    public void insertFirst(Item item){
        DoubleNode oldFirst = first;
        first = new DoubleNode(item);
        first.next = oldFirst;
        if(oldFirst != null){
            oldFirst.pre = first;
        }else{
            last = first;
        }
    }

    /**从尾部添加节点*/
    public void insertLast(Item item){
        DoubleNode oldLast = last;
        last = new DoubleNode(item);
        last.pre = oldLast;
        if(oldLast != null){
            oldLast.next = last;
        }else{
            first = last;
        }
    }

    /**从表头删除节点*/
    public void deleteFirst(){
        if(first == null){
            throw new RuntimeException("空列表不能删除");
        }
        first = first.next;
        if(first == null){
            last = null;
        }else{
            first.pre = null;
        }
    }

    /**删除尾节点*/
    public void deleteLast(){
        if(last == null){
            throw new RuntimeException("空列表不能删除");
        }
        last = last.pre;
        if(last != null){
            last.next = null;
        }else{
            first = null;
        }
    }

    /**判断链表是否为空*/
    public boolean isEmpty(){
        return first == null && last == null;
    }

    /**
     * 通过index查找对应的Node对象
     * */
    public DoubleNode findNodeByIndex(int index){
        DoubleNode node = first;
        for(int i = 0;i<index;i++){
            if(node == null){
                return null;
            }
            node = node.next;
        }
        return node;
    }

    /**计算链表的长度*/
    private int size(){
        int count = 0;
        for(DoubleNode index = first;index != null;index = index.next){
            count++;
        }
        return count;
    }

    /**在给定节点前插入节点*/
    public void insertItemForPre(DoubleNode node,Item item){
        DoubleNode oldPre = node.pre;
        node.pre = new DoubleNode(item);
        node.pre.pre = oldPre;
        if(oldPre != null){
            oldPre.next = node.pre;
        }else{
            first = node.pre;
        }
        node.pre.next = node;
    }

    /**从给定元素的后面插入元素*/
    public void insertItemForNext(DoubleNode node,Item item){
        DoubleNode oldNext = node.next;
        node.next = new DoubleNode(item);
        node.next.next = oldNext;
        if(oldNext != null){
            oldNext.pre = node.next;
        }else{
            last = node.next;
        }
        node.next.pre = node;
    }

    /**删除指定节点*/
    public void deleteNode(DoubleNode node){
        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            first = node.next;
        }
        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            last = node.pre;
        }
    }

    public static void main(String[] args){

    }
    @Override
    public String toString() {
        StringBuilder sb = ChapterUtil.getStringBuilder("[");
        boolean isEmpty = true;
        for(Item item : this){
            isEmpty = false;
            sb.append(item).append(",");
        }
        if(!isEmpty){
            sb.delete(sb.length() - 1,sb.length());
        }
        sb.append("]");

        //反向遍历，测试从后往前的链接是否正常
//        sb.append("  [");
//        DoubleNode index = last;
//        while(index != null){
//            sb.append(index.item);
//            if(index.pre != null){
//                sb.append(",");
//            }
//            index = index.pre;
//        }
//        sb.append("]");
        //反向遍历结束
        return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoubleLinkedIterator();
    }

    private class DoubleLinkedIterator implements Iterator<Item>{

        private DoubleNode index = first;

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

    private class DoubleNode{
        private Item item;
        private DoubleNode pre;
        private DoubleNode next;

        public DoubleNode(Item item){
            this.item = item;
        }
    }
}
