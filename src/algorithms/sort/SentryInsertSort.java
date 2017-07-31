package algorithms.sort;

/**
 * 带有哨兵的选择排序
 */
public class SentryInsertSort extends BaseSort{

    public SentryInsertSort(Comparable[] a) {
        super(a);
    }

    @Override
    public void sort() {
        int minIndex = 0;
        for(int i = 1;i<a.length;i++){
            if(less(a[i] , a[minIndex])){
                minIndex = i;
            }
        }
        exch(a,minIndex,0);  //设置哨兵
        for(int i = 1;i<a.length;i++){
            int j = i;
            while(true){
                if(less(a[j],a[j - 1])){  //
                    exch(a,j,j - 1);
                }else{   //必然有机会成立
                    break;
                }
                j--;
            }
        }
    }
}
