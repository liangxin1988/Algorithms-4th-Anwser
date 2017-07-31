package algorithms.sort;

/**
 * 实现选择排序的代码
 * */
public class InsertionSort extends BaseSort{

    public InsertionSort(Comparable[] a) {
        super(a);
    }

    public void sort() {
        for(int i = 1;i<a.length;i++){
            for(int j = i;j>0;j--){
                if(less(a[j - 1],a[j])){
                    continue;
                }
                exch(a, j - 1, j);
            }
        }
    }
}
