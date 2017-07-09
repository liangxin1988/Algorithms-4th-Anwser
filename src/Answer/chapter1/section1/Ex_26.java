package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_26 extends Answer0{
    @Override
    public void answer() {
        println("int a = 4,b = 2,c = 6,t;");
        println("if(a > b){t = a;a = b;b = t;}  //此次步骤结束后,a必然小于等于b");
        println("if(a > c){t = a;a = c;c = t;}  //结束后，a小于等于c。此时可以确定a为最小（小于b且小于c）");
        print("if(b > c){t = b;b = c;c = t;}  //b小于等于c，排序结束");
    }
}
