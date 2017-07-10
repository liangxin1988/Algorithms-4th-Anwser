package queue;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * Created by liangxin on 2017/7/4.
 */
public class ResizingArrayQueueOfStrings implements Queue<String> {

    /**使用数组实现队列*/
    private String[] contents = new String[2];

    private int start,end;  //start指向第一个元素的位置，end指向第一个空位
    private int count = 0;  //对队列中的元素计数。

    /**调整数组尺寸*/
    private void reSize(int size){
        String[] newArray = new String[size];
        for(int i = 0;i < count;i++){
            newArray[i] = contents[(i + start) % contents.length];  //复制元素的同时调整位置
        }
        contents = newArray;
        start = 0;
        end = count;
    }

    @Override
    public void enqueue(String s) {
        if(count == contents.length){
            reSize(2 * count);  //元素满了，需要扩容
        }
        contents[end++] = s;
        if(end == contents.length){
            end = 0;  //如果数组用完了，需要将指针指向开头，复用已经出列元素的内存
        }
        count++;
    }

    @Override
    public String dequeue() {
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能出队");
        }
        String s = contents[start];
        contents[start++] = null;  //避免内存泄露
        if(start == contents.length){
            start = 0;
        }
        count--;
        if(count > 0 && count <= contents.length / 4){
            reSize(contents.length / 2);
        }
        return s;
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
    public Iterator<String> iterator() {
        return new ResizingArrayQueueOfStringsIterator();
    }

    private class ResizingArrayQueueOfStringsIterator implements Iterator<String>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public String next() {
            return contents[((index++) + start) % contents.length];
        }
    }
    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }
}
