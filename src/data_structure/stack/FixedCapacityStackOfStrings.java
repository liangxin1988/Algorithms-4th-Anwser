package data_structure.stack;

import util.ChapterUtil;

import java.util.Iterator;

/**
 * 题目1.3.1中要求的，带有isfull方法的栈。
 * 提供了1.3.7中要求的peek方法
 * 提供了1.3.12中的迭代器和copy方法
 * */
public class FixedCapacityStackOfStrings implements Stack<String>{
    private String[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(String item){
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }

    public boolean isFull(){
        return N == a.length;  //当N等于a.length时，就无法通过a[N]访问元素了，此时数组已经没有空位
    }

    /**
     * 返回最近添加的元素，而不弹出
     * */
    public String peek(){
        return a[N - 1];  //与pop相比，不修改N的值，即可实现不弹出
    }
    @Override
    public String toString() {
        return ChapterUtil.iterableToString(this);
    }

    public static FixedCapacityStackOfStrings copy(FixedCapacityStackOfStrings fixedCapacityStackOfStrings){
        FixedCapacityStackOfStrings cache = new FixedCapacityStackOfStrings(100);
        for(String str : fixedCapacityStackOfStrings){
            cache.push(""+str);
        }
        FixedCapacityStackOfStrings result = new FixedCapacityStackOfStrings(100);
        for(String str : cache){
            result.push(str);
        }
        return result;
    }

    @Override
    public Iterator<String> iterator() {
        return new FixedCapacityStackOfStringsIterator();
    }

    private class FixedCapacityStackOfStringsIterator implements Iterator<String>{
        private int index = N - 1;
        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public String next() {
            return a[index--];
        }
    }
}