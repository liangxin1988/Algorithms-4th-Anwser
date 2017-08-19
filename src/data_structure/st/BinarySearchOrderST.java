package data_structure.st;

import java.util.ArrayList;

/**
 * 基于有序数组的有序符号表。
 * 其通过二分法查找使数组保持有序
 */
public class BinarySearchOrderST<Key extends Comparable<Key>,Value> extends AbsOrderST<Key,Value>{

    /**用来存放符号表中的键*/
    private Key[] keys;
    /**用来存放符号表中的值*/
    private Value[] values;

    /**保存符号表中的元素个数*/
    private int count = 0;

    public BinarySearchOrderST(){
        keys = (Key[]) new Comparable[2];
        values = (Value[]) new Object[2];
    }

    @Override
    public void delete(Key key) {
        int rank = rank(key);
        if(rank < count && keys[rank].compareTo(key) == 0){
            for(int i = rank;i<count - 1;i++){
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            keys[count - 1] = null;
            values[count - 1] = null;
            count--;
            if(count == keys.length / 4){
                reSize(keys.length / 2);
            }
        }
    }

    @Override
    public void put(Key key, Value value) {
        int rank = rank(key);
        if(rank < count && keys[rank].compareTo(key) == 0){
            values[rank] = value;
        }else{
            if(count == keys.length){
                reSize(keys.length * 2);
            }
            for(int i = count - 1;i >= rank;i--){
                keys[i + 1] = keys[i];
                values[i + 1] = values[i];
            }
            keys[rank] = key;
            values[rank] = value;
            count++;
        }
    }

    @Override
    public Value get(Key key) {
        if(isEmpty()){
            return null;
        }
        int rank = rank(key);
        if(rank < count && keys[rank].compareTo(key) == 0){
            return values[rank];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[count - 1];
    }

    @Override
    public Key floor(Key key) {
        int rank = rank(key);
        if(rank < count && keys[rank].compareTo(key) == 0){
            return key;
        }
        return rank == 0 ? null : keys[rank - 1];
    }

    @Override
    public Key ceiling(Key key) {
        int rank = rank(key);
        return rank == count ? null : keys[rank];
    }

    @Override
    public int rank(Key key) {
        return rank(key,0,count - 1);
    }

    /**二分法查找，找不到的情况下返回小于key的元素个数*/
    private int rank(Key key,int start,int end){
        if(start > end){
            return start;
        }
        int mid = (start + end) / 2;
        int i = keys[mid].compareTo(key);
        if(i > 0){
            return rank(key,start,mid - 1);
        }else if(i < 0){
            return rank(key,mid + 1,end);
        }else{
            return mid;
        }
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key start, Key end) {
        ArrayList<Key> list = new ArrayList<>(count);
        for(int i = rank(ceiling(start));i<=rank(floor(end));i++){
            list.add(keys[i]);
        }
        return list;
    }

    /**调整数组的大小*/
    private void reSize(int newSize){
        Key[] keyCache = (Key[]) new Comparable[newSize];
        Value[] valueCache = (Value[]) new Object[newSize];
        for(int i = 0;i<count;i++){
            keyCache[i] = keys[i];
            valueCache[i] = values[i];
        }
        keys = keyCache;
        values = valueCache;
    }
}
