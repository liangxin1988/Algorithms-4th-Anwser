package Answer.chapter4.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_6 extends Answer0 {
    @Override
    public void answer() {
        println("0 : 1 3");
        println("1 : 2 0");
        println("2 : 3 1");
        println("3 : 0 2");
        println("以上组合无法被创建。重点在添加边的操作，是相互的，如果添加了1 - 0就应该立刻添加0 - 1。而根据这条标准，以上组合无法被创建");
    }
}