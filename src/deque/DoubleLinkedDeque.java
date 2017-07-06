package deque;

import linked.DoubleLinked;
import util.ChapterUtil;

import java.util.Iterator;

/**
 * Created by liangxin on 2017/7/6.
 */
public class DoubleLinkedDeque<Item> implements Deque<Item> {
    private DoubleNode first,last;
    private int count;
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void pushLeft(Item item) {
        DoubleNode oldFirst = first;
        first = new DoubleNode(item);
        first.next = oldFirst;
        if(oldFirst != null){
            oldFirst.pre = first;
        }else{
            last = first;
        }
        count++;
    }

    @Override
    public void pushRight(Item item) {
        DoubleNode oldLast = last;
        last = new DoubleNode(item);
        last.pre = oldLast;
        if(oldLast != null){
            oldLast.next = last;
        }else{
            first = last;
        }
        count++;
    }

    @Override
    public Item popLeft() {
        if(first == null){
            throw new RuntimeException("空的双向队列，不能删除");
        }
        Item item = first.item;
        first = first.next;
        if(first != null){
            first.pre = null;
        }else{
            last = null;
        }
        count--;
        return item;
    }

    @Override
    public Item popRight() {
        if(first == null){
            throw new RuntimeException("空的双向队列，不能删除");
        }
        Item item = last.item;
        last = last.pre;
        if(last == null){
            first = null;
        }else{
            last.next = null;
        }
        count--;
        return item;
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
        return new DoubleLinkedDequeiterator();
    }

    private class DoubleLinkedDequeiterator implements Iterator<Item>{

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
