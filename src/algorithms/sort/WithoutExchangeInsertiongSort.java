package algorithms.sort;

/**
 * 不需要交换元素的插入排序
 */
public class WithoutExchangeInsertiongSort extends BaseSort {
    public WithoutExchangeInsertiongSort(Comparable[] a) {
        super(a);
    }

    @Override
    public void sort() {
        for(int i = 1;i<a.length;i++){
            Comparable current = a[i];  //拿到当前无序元素的第一个元素
            int j = i - 1;
            for(;j>=0 && a[j].compareTo(current) > 0;j--){
                    a[j + 1] = a[j]; //如果找到比i大的元素，则直接将元素右移，覆盖旧的元素
            }
            a[j + 1] = current;
        }
    }
}
