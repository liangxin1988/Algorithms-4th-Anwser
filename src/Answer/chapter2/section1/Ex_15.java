package Answer.chapter2.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_15 extends Answer0 {
    @Override
    public void answer() {
        println("选择排序");
        println("经典的选择排序场景，最多交换N-1次即可。题目中给出的空闲仓位是用来在交换时当做临时缓存。注意这个仓位不能用来存放内循环中的最小值，因为如果这样就得不停的进行交换。应该确定那个最小后才放入这个位置。");
    }
}
