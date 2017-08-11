package data_structure.max_pq;

/**
 * 基于有序堆的优先队列
 */
public class HeapMaxPQ<Key extends Comparable<Key>> extends AbsMaxPQ<Key> {

    private Key[] contents;
    private int count = 0;
    public HeapMaxPQ(int max){
        contents = (Key[]) new Comparable[max + 1];  //将contents[0] 空出来
    }

    public HeapMaxPQ(){
        this(10);
    }

    @Override
    public void insert(Key v) {
        if(count + 1 == contents.length){
            reSize(contents.length * 2);
        }
        contents[++count] = v;
        swim(count);
    }

    private void swim(int k){

        while(k > 1 && less(contents[k / 2],contents[k])){
            exch(contents,k,k / 2);
            k /= 2;
        }
    }

    @Override
    public Key max() {
        return contents[1];
    }

    @Override
    public Key delMax() {
        if(isEmpty()){
            throw new RuntimeException("空队列");
        }
        Key max = max();
        exch(contents,1,count--);
        contents[count + 1] = null;
        sink(1);
        if(count > 0 && count == contents.length / 4){
            reSize(contents.length / 2);
        }
        return max;
    }

    private void sink(int k){
        while(k * 2 <= count){
            int j = k * 2;  //第一个子节点
            if(j < count && less(contents[j],contents[j + 1])) j++;
            if(!less(contents[k],contents[j])){
                break;
            }

            exch(contents,k,j);
            k = j;
        }
    }

    @Override
    public int size() {
        return count;
    }

    private void reSize(int newSize){
        Key[] cache = (Key[]) new Comparable[newSize];
        for(int i = 1;i<=count;i++){
            cache[i] = contents[i];
        }
        contents = cache;
    }

    public Key[] getContents(){
        Key[] cache = (Key[]) new Comparable[count];
        for(int i = 0;i<count;i++){
            cache[i] = contents[i + 1];
        }
        return cache;
    }
}
