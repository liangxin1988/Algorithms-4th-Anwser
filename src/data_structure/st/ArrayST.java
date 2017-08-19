package data_structure.st;

import util.ChapterUtil;

import java.util.ArrayList;

/**
 * 基于无序数组实现符号表
 */
public class ArrayST<Key,Value> extends AbsST<Key,Value> {

    private Key[] keys;
    private Value[] values;

    private int count;

    @Override
    public void put(Key key, Value value) {
        for(int i = 0;i<count;i++){
            if(keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        if(count == keys.length){
            reSize(keys.length * 2);
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public Value get(Key key) {
        for(int i = 0;i<count;i++){
            if(key.equals(keys[i])){
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        for(int i = 0;i<count;i++){
            if(key.equals(keys[i])){
                for(int j = i;j<count - 1;j++){
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                keys[count - 1] = null;
                values[count - 1] = null;
                count--;
                return;
            }
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterable<Key> keys() {
        ArrayList<Key> list = new ArrayList<>();
        for(int i = 0;i<count;i++){
            list.add(keys[i]);
        }
        return list;
    }

    public ArrayST(){
        reSize(2);
    }

    /**动态调整数组大小*/
    private void reSize(int newSize){
        Key[] cacheKey = (Key[]) new Object[newSize];
        Value[] cacheValue = (Value[]) new Object[newSize];
        for(int i = 0;i<count;i++){
            cacheKey[i] = keys[i];
            cacheValue[i] = values[i];
        }
        keys = cacheKey;
        values = cacheValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Key k : keys()){
            sb.append("(").append(k).append(",").append(get(k)).append(")").append(",");
        }
        sb.delete(sb.length() - 1,sb.length());
        sb.append("]");
        return sb.toString();
    }
}
