package deque;

import util.ChapterUtil;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 使用可变数组实现双向队列
 */
public class ResizingArrayDeque<Item> implements Deque<Item> {

    private Item[] contents;  //通过数组保存元素
    private int start,end;  //对第一个元素的起点和第一个空位的起点进行计数。
    private int count;  //对数组元素计数

    @Override
    public void pushLeft(Item item) {
        if(isFull()){
            resize(2 * contents.length);
        }
        start--;
        if(start < 0){
            start = contents.length - 1;
        }
        contents[start] = item;
        count++;
    }

    @Override
    public void pushRight(Item item) {
        if(isFull()){
            resize(2 * contents.length);
        }
        contents[end++] = item;
        if(end == contents.length){
            end = 0;
        }
        count++;
    }

    @Override
    public Item popLeft() {
        if(isEmpty()){
            throw new RuntimeException("空的双向队列，无法删除");
        }
        Item item = contents[start];
        contents[start++] = null;
        if(start == contents.length){
            start = 0;
        }
        count--;
        if(count > 0 && count == contents.length / 4){
            resize(contents.length / 2);
        }
        return item;
    }

    @Override
    public Item popRight() {
        if(isEmpty()){
            throw new RuntimeException("空的双向队列，无法删除");
        }
        end--;
        if(end < 0){
            end = contents.length - 1;
        }
        Item item = contents[end];
        contents[end] = null;
        count--;
        if(count > 0 && count == contents.length / 4){
            resize(contents.length / 2);
        }
        return null;
    }

    /**判断数组是否已满*/
    private boolean isFull(){
        return count == contents.length;
    }
    @Override
    public String toString() {
        StringBuilder sb = ChapterUtil.getStringBuilder();
        sb.append("[");
        boolean isEmpty = true;
        for(Item item : this){
            isEmpty = false;
            sb.append(item).append(",");
        }
        if(!isEmpty){
            sb.delete(sb.length() - 1,sb.length());
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator<Item>{

        private int index = start;
        private int c = count;

        @Override
        public boolean hasNext() {
            return c != 0;
        }

        @Override
        public Item next() {
            Item item = contents[index++];
            if(index >= contents.length){
                index = 0;
            }
            c--;
            return item;
        }
    }

    /**调整数组尺寸*/
    private void resize(int size){
        Item[] cache = (Item[]) new Object[size];
        for(int i = 0;i<count;i++){
            cache[i] = contents[(i + start) % contents.length];
        }
        start = 0;
        end = count;
        contents = cache;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }


    public ResizingArrayDeque(){
        contents = (Item[]) new Object[2];
    }
}
