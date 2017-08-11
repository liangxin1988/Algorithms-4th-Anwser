package data_structure.max_pq;

/**
 * 基于无序链表的优先队列
 */
public class LinkedMaxPQ<Key extends Comparable<Key>> extends AbsMaxPQ<Key>{

    private Node first;
    private int count;

    @Override
    public void insert(Key v) {
        count++;
        if(first == null){
            first = new Node(null,v,null);
        }else{
            first.pre = new Node(null,v,first);
            first = first.pre;
        }
    }

    @Override
    public Key max() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        Key max = first.item;
        for(Node index = first;index.next != null;index = index.next){
            if(less(max,index.item)){
                max = index.item;
            }
        }
        return max;
    }

    @Override
    public Key delMax() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        Key max = first.item;
        if(count == 1){
            first = null;
        }else{
            Node maxNode = first;
            for(Node index = first;index != null;index = index.next){
                if(less(max,index.item)){
                    maxNode = index;
                    max = index.item;
                }
            }
            if (maxNode.pre != null) {
                maxNode.pre.next = maxNode.next;
            }else{
                first = maxNode.next;
                first.pre = null;
            }
            if(maxNode.next != null){
                maxNode.next.pre = maxNode.pre;
            }else{
                maxNode.pre.next = null;
            }
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
        Node next;
        Node pre;

        public Node(Node pre,Key item,Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}
