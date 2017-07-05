package list;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 演示用链表。
 */
public class SimpleList<Item> implements Iterable<Item> {

    /**链表的首节点*/
    private Node<Item> first;

    /**对节点个数技术*/
    private int count;

    /**
     * 删除第k位的数据
     * 1.3.20题目
     * */
    public void deleteForIndex(int k){
        if(k < 0 || k >= size()){
            throw new RuntimeException("编号异常");
        }
        if(k == 0){  //针对删除第一个元素进行特殊处理
            deleteFirst();
            return;
        }
        Node<Item> node = first;
        for(int i = 1;i<k;i++){  //找到第k - 1个元素
            node = node.next;
        }
        node.next = node.next.next;
        count--;
    }

    /**从头部插入数据*/
    public void addFirst(Item item){
        first = new Node<>(item,first);
        count++;
    }

    /**删除前通过这个方法检查链表是否为空*/
    private void deleteCheck(){
        if(isEmpty()){
            throw new RuntimeException("空链表无法删除");
        }
    }

    /**删除第一个元素*/
    public void deleteFirst(){
        deleteCheck();
        first = first.next;
        count--;
    }

    /**
     * 删除链表的尾节点
     * 练习1.3.19
     * */
    public void deleteLast(){
        deleteCheck();
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

        private Node<Item> index = first;

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
    public Node getFirst(){
        return first;
    }


}
