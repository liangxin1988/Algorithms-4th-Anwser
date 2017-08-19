package data_structure.st;

import java.util.ArrayList;

/**
 * 另一个基于有序数组的有序符号表。其内部通过一个Item对象而非两个平行数组来保存key和value
 */
public class ItemBinarySearchST<Key extends Comparable<Key>,Value> extends AbsOrderST<Key,Value>{

    private Item<Key,Value>[] items;
    private int count;

    @Override
    public void put(Key key, Value value) {
        int rank = rank(key);
        if(rank < count && items[rank].key.equals(key)){
            items[rank].value = value;
        }else{
            if(count == items.length){
                reSize(items.length * 2);
            }
            for(int i = count - 1;i>=rank;i--){
                items[i + 1] = items[i];
            }
            items[rank] = new Item(key,value);
            count++;
        }
    }

    @Override
    public void delete(Key key) {
        int rank = rank(key);
        if(rank < count && items[rank].key.equals(key)){
            for(int j = rank + 1;j<=count - 1;j++){
                items[j - 1] = items[j];
            }
            items[count - 1] = null;
            count--;
            if(count > 0 && count == items.length / 4){
                reSize(items.length / 2);
            }
        }
    }

    @Override
    public Value get(Key key) {
        int rank = rank(key);
        if(rank < count && items[rank].key.equals(key)){
            return items[rank].value;
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Key min() {
        return items[0].key;
    }

    @Override
    public Key max() {
        return items[count - 1].key;
    }

    @Override
    public Key floor(Key key) {
        int rank = rank(key);
        if(rank < count && items[rank].key.compareTo(key) == 0){
            return key;
        }
        return rank == 0 ? null : items[rank - 1].key;
    }

    @Override
    public Key ceiling(Key key) {
        int rank = rank(key);
        return rank == count ? null : items[rank].key;
    }

    @Override
    public int rank(Key key) {
        return rank(key,0,count - 1);
    }

    private int rank(Key key,int start,int end){
        if(start > end){
            return start;
        }
        int mid = (start + end) / 2;
        int cmp = items[mid].key.compareTo(key);
        if(cmp > 0){
            return rank(key,start,mid - 1);
        }else if(cmp < 0){
            return rank(key,mid + 1,end);
        }else{
            return mid;
        }
    }

    @Override
    public Key select(int k) {
        return items[k].key;
    }

    public ItemBinarySearchST(){
        reSize(2);
    }

    @Override
    public Iterable<Key> keys(Key start, Key end) {
        ArrayList<Key> list = new ArrayList<>(count);
        for(int i = rank(ceiling(start));i<=rank(floor(end));i++){
            list.add(items[i].key);
        }
        return list;
    }


    private void reSize(int newSize){
        Item[] cache = new Item[newSize];
        for(int i = 0;i<count;i++){
            cache[i] = items[i];
        }
        items = cache;
    }

    public static class Item<Key extends Comparable<Key>,Value> implements Comparable<Item<Key,Value>>{
        Key key;
        Value value;

        public Item(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key+"";
        }

        @Override
        public int compareTo(Item<Key,Value> o) {
            return key.compareTo(o.key);
        }
    }

    private void checkEmpty(){
        if(count == 0){
            throw new RuntimeException("空字符表不能操作");
        }
    }

    public ItemBinarySearchST(Item[] items){
        this.items = items;
        mergeCache = new Item[items.length];
        mergeSort(items,0,items.length - 1);
    }

    private Item[] mergeCache;
    private void mergeSort(Item[] items,int start,int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(items,start,mid);
        mergeSort(items,mid + 1,end);
        merge(items,start,mid,end);
    }

    private void merge(Item[] items,int start,int mid,int end){
        int i = start,j = mid + 1;
        for(int k = start;k <= end;k++){
            mergeCache[k] = items[k];
        }
        for(int k = start;k <= end;k++){
            if(i > mid){
                items[k] = mergeCache[j++];
            }else if(j > end){
                items[k] = mergeCache[i++];
            }else if(mergeCache[i].compareTo(mergeCache[j]) > 0){
                items[k] = mergeCache[j++];
            }else{
                items[k] = mergeCache[i++];
            }
        }
    }
}
