package Answer.chapter2.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_14 extends Answer0{
    @Override
    public void answer() {
        println("比较最上面的两张牌，将较小的牌交换到上面，并放入牌底部。这样在比较过所有牌后，最大的牌在最下面");
        println("再进行一轮比较，找出第二大的牌，将两张牌依次插入牌的底部");
        println("不断重复该步骤，直到整副牌有序");
    }
}
