package data_structure.max_pq;

/**
 * 继续无序数组实现优先队列
 */
public class ResizingArrayMaxPQ<Key extends Comparable<Key>> extends AbsMaxPQ<Key> {

    private Key[] contents;

    private int count;
    public ResizingArrayMaxPQ(){
        this(10);
    }

    public ResizingArrayMaxPQ(int max){
        contents = (Key[]) new Comparable[max + 1];
    }

    @Override
    public void insert(Key v) {
        if(count == contents.length){
            reSize(contents.length * 2);
        }
        contents[count++] = v;
    }

    @Override
    public Key max() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        return contents[getMaxIndex()];
    }

    private int getMaxIndex(){
        int maxIndex = 0;
        for(int i = 1;i<count;i++){
            if(less(contents[maxIndex],contents[i])){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public Key delMax() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        int maxIndex = getMaxIndex();
        Key max = contents[maxIndex];
        exch(contents,maxIndex,--count);
        if(count > 0 && count == contents.length / 4){
            reSize(contents.length / 2);
        }
        return max;
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
