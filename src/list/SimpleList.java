package list;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import java.util.Iterator;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 演示用链表。
 */
public class SimpleList<Item> implements Iterable<Item> {

    /**链表的首节点*/
    private Node first;

    /**对节点个数技术*/
    private int count;

    /**从头部插入数据*/
    public void addFirst(Item item){
        first = new Node(item,first);
        count++;
    }

    /**
     * 删除链表的尾节点
     * 练习1.3.19
     * */
    public void deleteLast(){
        if(isEmpty()){
            throw new RuntimeException("空链表无法删除");
        }
        count--;
        if(first.next == null){  //只有一个元素，直接删除
            first = null;
            return;
        }
        //缓存找过的节点，for循环结束的时候，preNode为last的上一个节点。需要通过这个节点删除last
        Node preNode = first;
        //遍历链表,找到最后一个节点
        for(Node index = first.next;index != null;index = index.next){
            if (index.next == null){
                preNode.next = null;  //删除最后一个节点
            }else{
                preNode = index;  //将index赋值给preNode，准备下一轮判断。
            }
        }
    }

    public static void main(String[] args){
        SimpleList<Integer> simpleList = new SimpleList<>();
        simpleList.addFirst(1);
        simpleList.deleteLast();
        println(simpleList);
        simpleList.deleteLast();
    }

    /**获取链表元素个数*/
    public int size(){
        return count;
    }

    /**判断链表是否为空*/
    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = ChapterUtil.getStringBuilder("[");
        for(Item item : this){
            sb.append(item).append(",");
        }
        if(!isEmpty()){
            sb.delete(sb.length()-1,sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new SimpleListIterator();
    }

    /**链表通用的遍历器*/
    private class SimpleListIterator implements Iterator<Item>{

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

    /**链表中的节点*/
    private class Node{
        private Item item;
        private Node next;

        //构造函数为了简化对链表的操作。
        Node(Item item){
            this.item = item;
        }
        Node(Item item,Node next){
            this(item);
            this.next = next;
        }
    }
}
