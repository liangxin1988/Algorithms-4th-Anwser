package data_structure.queue;

import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import java.util.Iterator;

/**
 * 随机队列
 * 1.3.35
 */
public class RandomQueue<Item> implements Queue<Item> {

    private Item[] contents;
    private int count;

    /**随机返回一个数据，但不出列*/
    public Item sample(){
        if(isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return contents[StdRandom.uniform(count)];
    }

    @Override
    public void enqueue(Item item) {
        if(isFull()){
            resize(2 * contents.length);
        }
        contents[count++] = item;
    }

    @Override
    public Item dequeue() {
        swap(count - 1,StdRandom.uniform(count));
        return contents[--count];
    }

    /**
     * 交换数组中的两个元素
     * */
    private void swap(int i,int j){
        Item temp = contents[i];
        contents[i] = contents[j];
        contents[j] = temp;
    }

    /**判断队列是否以满*/
    private boolean isFull(){
        return count == contents.length;
    }
    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    /**
     * 随机迭代器
     * 1.3.36
     * */
    private class RandomQueueIterator implements Iterator<Item>{

        private Item[] cache = (Item[]) new Object[count];
        private int index = 0;

        public RandomQueueIterator(){
            for(int i = 0;i<count;i++){
                cache[i] = contents[i];
            }
            StdRandom.shuffle(cache);
        }

        @Override
        public boolean hasNext() {
            return index != cache.length;
        }

        @Override
        public Item next() {
            return cache[index++];
        }
    }

    public RandomQueue(){
        contents = (Item[]) new Object[2];
    }

    /**动态调整数组尺寸*/
    private void resize(int size){
        Item[] cache = (Item[]) new Object[size];
        for(int i = 0;i<count;i++){
            cache[i] = contents[i];
        }
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
}
