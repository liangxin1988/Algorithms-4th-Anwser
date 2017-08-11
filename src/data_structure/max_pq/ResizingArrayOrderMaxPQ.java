package data_structure.max_pq;

/**
 * 基于有序数组实现的优先队列
 */
public class ResizingArrayOrderMaxPQ<Key extends Comparable<Key>> extends AbsMaxPQ<Key>{

    private Key[] contents;
    private int count = 0;

    public ResizingArrayOrderMaxPQ(int max){
        contents = (Key[]) new Comparable[max];
    }

    public ResizingArrayOrderMaxPQ(){
        this(10);
    }

    @Override
    public void insert(Key v) {
        if(count == contents.length){
            reSize(contents.length * 2);
        }
        int i;
        for(i = count - 1;i >= 0 && less(v,contents[i]);i--){
            contents[i + 1] = contents[i];
        }
        contents[i + 1] = v;
        count++;
    }

    @Override
    public Key max() {
        return contents[count - 1];
    }

    @Override
    public Key delMax() {
        return contents[--count];
    }

    @Override
    public int size() {
        return count;
    }

    private void reSize(int max){
        Key[] cache = (Key[]) new Comparable[max];
        for(int i = 0;i<count;i++){
            cache[i] = contents[i];
        }
        contents = cache;
    }
}
