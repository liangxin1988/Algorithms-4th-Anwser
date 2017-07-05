package list;

import com.sun.istack.internal.NotNull;
import util.ChapterUtil;

import java.util.Iterator;

/**
 * 演示用链表。
 */
public class SimpleList<Item> implements Iterable<Item> {

    /**链表的首节点*/
    private Node first;

    /**
     * 删除第k位的数据
     * 1.3.20题目
     * */
    public void deleteForIndex(int k){
        if(k == 0 || first == null){  //针对删除第一个元素进行特殊处理
            deleteFirst();
            return;
        }
        Node node = first;
        for(int i = 1;i<k;i++){  //找到第k - 1个元素
            node = node.next;
            if(node == null || node.next == null){
                return;
            }
        }
        node.next = node.next.next;
    }

    /**从头部插入数据*/
    public void addFirst(Item item){
        first = new Node(item,first);
    }

    /**
     * 从以node为首节点的链表中尝试查找item。并返回链表中是否包含对应的数据
     * 1,3,21题目
     * */
    public boolean find(Node node,Item item){
        if(node == null || item == null){  //空列表不可能包含item;
            return false;
        }
        for(Node index = node;index != null;index = index.next){
            if(item.equals(index.item)){
                return true;
            }
        }
        return false;
    }

    /**
     * 删除给定节点的所有后续节点
     * 1.3.24题
     * */
    public void removeAfter(Node node){
        if(node != null){
            node.next = null;
        }
    }
    /**
     * 将Node2的整条链表追加到node1后面。
     * 题目1.3.25
     * */
    public void insertAfter(Node node1,Node node2){
        if(node1 == null || node2 == null){
            return;
        }
        Node nextNode = node1.next;
        node1.next = node2;
        for(Node index = node2;index != null;index = index.next){
            if(index.next == null){
                index.next = nextNode;
                return;
            }
        }
    }
    /**
     * 获取第k个节点
     * */
    @NotNull
    public Node getItemForIndex(int k){
        Node node = first;
        for(int i = 0;i<k;i++){
            node = node.next;
            if(node == null){
                break;
            }
        }
        return node;
    }

    /**删除第一个元素*/
    public void deleteFirst(){
        if(first != null)
            first = first.next;
    }

    /**
     * 删除链表的尾节点
     * 练习1.3.19
     * */
    public void deleteLast(){
        if(first == null || first.next == null){  //只有一个元素，直接删除
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

    /**获取链表的首节点*/
    @NotNull
    public Node getFirst(){
        return first;
    }

    /**获取最后一个元素*/
    public Node getLast(){
        if(first == null){
            return null;
        }
        for(Node index = first;index != null;index = index.next){
            if(index.next == null){
                return index;
            }
        }
        return null;
    }

    /**
     * 从给定节点表示的链表中，删除所有数据为item的节点
     * */
    public void removeForKey(Item item){
        Node preNode = null;
        for(Node index = first;index != null;index = index.next){
            if(!index.item.equals(item)){
                if(preNode == null){
                    first = preNode = index;
                }else{
                    preNode.next = index;
                    preNode = index;
                }
            }
        }
        if(preNode == null){
            first = null;
        }else{
            preNode.next = null;
        }
    }

    /**
     * 清除链表中的所有数据
     * */
    public void clearLink(){
        first = null;
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
}
