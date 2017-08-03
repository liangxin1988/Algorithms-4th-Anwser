package Answer.chapter2.section2;

import Answer.base.Answer0;
import algorithms.sort.LocalCacheMergeSort;
import algorithms.sort.QuickMergeSort;
import framework.Fixme;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
@Fixme(info = "第三个改进暂时不知道怎么处理了，先忽略")
public class Ex_11 extends Answer0 {
    @Override
    public void answer() {
        int[] array = ChapterUtil.getRandomIntArray(10);
        Comparable[] a = new Comparable[array.length];
        for(int i = 0;i<a.length;i++){
            a[i] = array[i];
        }
        QuickMergeSort sort = new QuickMergeSort(a);
        sort.sort();
        println("" + sort.isSorted());
    }
}
