package data_structure.queue;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 删除第k个元素
 * 1.3.38
 */
public class ArrayGeneralizedQueue<Item> implements GeneralizedQueue<Item>{

    private Item[] contents;
    private int count;

    public ArrayGeneralizedQueue(){
        contents = (Item[]) new Object[2];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    /**判断数组是否以满*/
    private boolean isFull(){
        return count == contents.length;
    }

    public void insert(Item item){
        if(isFull()){
            resize(2 * contents.length);
        }
        contents[count++] = item;
    }

    public Item delete(int k){
        if(k < 0 || k >= contents.length){
            throw new RuntimeException("index越界");
        }
        Item item = contents[k];
        for(int i = k + 1;i<count;i++){
            contents[i - 1] = contents[i];
        }
        count--;
        if(count > 0 && count == contents.length / 4){
            resize(contents.length / 2);
        }
        return item;
    }

    /**调整数组的尺寸*/
    private void resize(int size){
        Item[] cache = (Item[]) new Object[size];
        for(int i = 0;i<count;i++){
            cache[i] = contents[i];
        }
        contents = cache;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayGeneralizedQueueIterator();
    }

    private class ArrayGeneralizedQueueIterator implements Iterator<Item>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index != count;
        }

        @Override
        public Item next() {
            return contents[index++];
        }
    }

    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }
}
