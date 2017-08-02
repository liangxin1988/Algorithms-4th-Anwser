package Answer.chapter2.section2;

import Answer.base.Answer0;
import algorithms.sort.BaseSort;
import algorithms.sort.LocalCacheMergeSort;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_9 extends Answer0 {
    @Override
    public void answer() {
        int[] array = ChapterUtil.getRandomIntArray(10);
        Comparable[] a = new Comparable[array.length];
        for(int i = 0;i<a.length;i++){
            a[i] = array[i];
        }
        LocalCacheMergeSort sort = new LocalCacheMergeSort(a);
        sort.sort();
        println("" + sort.isSorted());
    }
}