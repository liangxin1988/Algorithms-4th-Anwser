package Answer.chapter2.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_13 extends Answer0 {
    @Override
    public void answer() {
        println("进行双层循环。");
        println("外层循环确定错误纸牌的位置（如当前位置在正确排序后应该是黑桃，现在却是红桃）");
        println("如果外层循环找到了一个错误纸牌的位置，则从这张牌向下进行内层循环，找到外层循环指定位置应该放置的纸牌，并在找到后交换两张牌的位置");
        println("为了减少遍历次数，内层循环可以保存（记住）当前已经找过的位置，如果下一次外层循环找的是同样花色的纸牌，则内层循环从上一次停止的位置继续进行。这样保证了内层循环执行完一次，就可以对一种花色进行完全排序");

    }
}