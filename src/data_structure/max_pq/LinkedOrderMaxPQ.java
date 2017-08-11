package data_structure.max_pq;

/**
 * 基于有序链表的优先队列
 */
public class LinkedOrderMaxPQ<Key extends Comparable<Key>> extends AbsMaxPQ<Key>{

    private Node first,last;
    private int count = 0;

    @Override
    public void insert(Key v) {
        count++;
        if(first == null){
            last = first = new Node(null,v,null);
        }else{
            Node index = first;
            for(;index != null;index = index.next){  //遍历链表，找到第一个小于v的节点
                if(less(index.item,v)){
                    break;
                }
            }
            if(index == null){
                last = last.next = new Node(last,v,null);
            }else{
                Node oldPre = index.pre;
                index.pre = new Node(oldPre,v,index);
                if(oldPre != null){
                    oldPre.next = index.pre;
                }else{
                    first = index.pre;
                }
            }
        }
    }

    @Override
    public Key max() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        return first.item;
    }

    @Override
    public Key delMax() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        Key max = first.item;
        first = first.next;
        if(first != null){
            first.pre = null;
        }else{
            last = null;
        }
        count--;
        return max;
    }

    @Override
    public int size() {
        return count;
    }

    private class Node{
        Key item;
        Node pre;
        Node next;
        private Node(Node pre,Key item,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}
