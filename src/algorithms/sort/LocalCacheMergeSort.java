package algorithms.sort;

/**
 * 使用局部缓存进行排序
 */
public class LocalCacheMergeSort extends BaseSort{


    public LocalCacheMergeSort(Comparable[] a) {
        super(a);
    }

    @Override
    public void sort() {
        Comparable[] cache = new Comparable[a.length];
        sort(a,cache,0,a.length - 1);
    }

    private void sort(Comparable[] a,Comparable[] cache,int start,int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        sort(a,cache,start,mid);
        sort(a,cache,mid + 1,end);
        merge(a,cache,start,mid,end);
    }

    private void merge(Comparable[] a,Comparable[] cache, int start, int mid, int end) {
        int i = start,j = mid + 1;
        for(int k = start;k<=end;k++){
            cache[k] = a[k];
        }
        for(int k = start;k<=end;k++){
            if(i > mid){
                a[k] = cache[j++];
            }else if(j > end){
                a[k] = cache[i++];
            }else if(less(cache[i],cache[j])){
                a[k] = cache[i++];
            }else{
                a[k] = cache[j++];
            }
        }
    }
}
