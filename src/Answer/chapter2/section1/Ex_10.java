package Answer.chapter2.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_10 extends Answer0 {
    @Override
    public void answer() {
        println("希尔排序是利用了插入排序，整体接近有序的情况下排序效率非常高的特点，将元素大范围移动进行排序，从而使数组接近有序，控制了插入排序的效率逐步提升。而选择排序与内容无关，无法通过这种方式提升效率");
    }
}
