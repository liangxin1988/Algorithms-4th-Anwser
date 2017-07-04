package queue;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 定义一个定长队列，如果入列的时候元素个数超限，则出列后再入列
 */
public class FixedLengthQueue<Item> implements Queue<Item> {

    private Item[] contents;
    private int start,end;  //指向队列中第一个元素和第一个空位
    private int count = 0;  //计数队列

    /**
     * 构造方法，需要同时设置队列的最大长度
     * */
    public FixedLengthQueue(int size){
        contents = (Item[])new Object[size];
    }

    @Override
    public void enqueue(Item item) {
        contents[end] = item;
        if(end == start && count != 0){
            start++;  //相当于将第一个元素出列
            if(start == contents.length){
                start = 0;
            }
        }else{
            count++;
        }
        end++;
        if(end == contents.length){
            end = 0;
        }
    }

    @Override
    public Item dequeue() {
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能出列");
        }
        Item item = contents[start++];
        if(start == contents.length){
            start = 0;
        }
        return item;
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
    public Iterator<Item> iterator() {
        return new ResizingArrayQueueOfStringsIterator();
    }

    private class ResizingArrayQueueOfStringsIterator implements Iterator<Item>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public Item next() {
            return contents[((index++) + start) % contents.length];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = ChapterUtil.getStringBuilder();
        sb.append("[");
        for(Item s : this){
            sb.append(s).append(",");
        }
        if(!isEmpty())
            sb.delete(sb.length() - 1,sb.length());
        sb.append("]");
        return sb.toString();
    }
}
