package Answer.chapter2.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_6 extends Answer0 {
    @Override
    public void answer() {
        println("插入排序更快");
        println("选择排序与输入无关，必然执行N此交换和~N^2 / 2次比较");
        println("而插入排序，只需要执行N次比较，确定所有数均为有序即可，不用执行交换");
    }
}