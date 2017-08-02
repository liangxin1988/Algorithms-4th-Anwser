package Answer.chapter2.section2;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_4 extends Answer0 {
    @Override
    public void answer() {
        println("数组的有序性，可以通过倒置（数组中的一对数，其中前面的数字大于后面的数组）的个数来确定，当倒置为0时数组有序");
        println("归并可以调整两个数组中元素的先后关系，但是不能调整同一个数组中的前后关系，即无法修正数组中的倒置个数");
        println("所以，如果两个数组中含有倒置的元素，那么最终的归并结果中也必然含有倒置，使排序失败");
    }
}