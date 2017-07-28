package Answer.chapter2.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_8 extends Answer0 {
    @Override
    public void answer() {
        println("平方级别");
        println("如果只有3种元素，可认为3种元素的数量为a,b,c，且a + b + c = n");
        println("总的数字对为n(n - 1)/2 = (n^2 - n)/2个，其中，相等元素的数字对为a(a - 1)/2+b(b - 1)/2+c(c - 1)/2 = (a^2 + b^2 + c^2 - n) / 2。");
        println("则不同的数字对为(n^2 - a^2 - b^2 - c^2) / 2。随机情况下认为其中一半是倒置，则倒置的数量为n^2与常量的乘积，也即平方级别。");
    }
}