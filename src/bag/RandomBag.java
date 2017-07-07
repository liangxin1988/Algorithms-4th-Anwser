package bag;

import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 随机背包
 */
public class RandomBag<Item> implements Bag<Item> {

    private Item[] contents;
    private int count = 0;

    @Override
    public void add(Item item) {
        if(isFull()){
            resize(2 * contents.length);
        }
        contents[count++] = item;
    }

    /**判断背包是否以满*/
    private boolean isFull(){
        return count == contents.length;
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
    public String toString() {
        StringBuilder sb = ChapterUtil.getStringBuilder("[");
        for(Item item : this){
            sb.append(item).append(",");
        }
        if(!isEmpty()){
            sb.delete(sb.length() - 1,sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item>{

        private Item[] cache = (Item[]) new Object[count];
        private int index = 0;

        public RandomBagIterator(){
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

    public RandomBag(){
        contents = (Item[]) new Object[2];
    }

    /**调整数组尺寸*/
    private void resize(int size){
        Item[] cache = (Item[]) new Object[size];
        for(int i = 0;i<count;i++){
            cache[i] = contents[i];
        }
        contents = cache;
    }
}
