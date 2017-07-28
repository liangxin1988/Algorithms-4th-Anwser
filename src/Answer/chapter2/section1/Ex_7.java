package Answer.chapter2.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_7 extends Answer0 {
    @Override
    public void answer() {
        println("选择排序更快");
        println("选择排序固定的需要N次交换和~N^2 / 2次比较");
        println("插入排序，在最坏情况下，每一个无序数组的元素都要与整个有序数组元素比较并且交换，所以需要~N^2 / 2次比较和~n^2 / 2次交换。");
        println("而在N比较大的情况下，两种算法的比较次数一样，但是交换次数插入排序大于选择排序");
    }
}