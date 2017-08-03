package algorithms.sort;

/**
 * 实现优化后的归并排序
 */
public class QuickMergeSort extends BaseSort{

    /**小数组阈值*/
    private static final int LIMIT = 5;

    public QuickMergeSort(Comparable[] a) {
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

        //改进点1：针对小于某个范围的数组直接进行插入排序
        if(end - start <= LIMIT){
            for(int i = start + 1;i<=end;i++){
                for(int j = i;j>start;j--){
                    if(less(a[j],a[j - 1])){
                        exch(a,j,j - 1);
                    }
                }
            }
            return;
        }

        int mid = (start + end ) / 2;
        sort(a,cache,start,mid);
        sort(a,cache,mid + 1,end);
        merge(a,cache,start,mid,end);
    }

    private void merge(Comparable[] a, Comparable[] cache, int start, int mid, int end) {
        //改进点2：针对数组有序性的判断
        if(less(a[mid],a[mid + 1])){
            return;
        }

        int i = start,j = mid + 1;
        for(int k = start;k<=end;k++){
            cache[k] = a[k];
        }

        for(int k = start;k <= end;k++){
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
