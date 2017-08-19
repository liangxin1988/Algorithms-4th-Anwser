package Answer.chapter3.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_6 extends Answer0 {
    @Override
    public void answer() {
        println("put次数");
        println("在插入阶段（不考虑最短长度），每个单词都会进行一次put（包括重复单词），put数为W。");
        println("在查找最大值阶段，将初始最大值进行put，put数为1.");
        println("总put数为W + 1");

        println("get次数");
        println("在插入阶段（不考虑最短长度），所有单词要通过contains()判断一次key是否存在（内部自动调用一次get()），如果已经存在，则通过get获取现有value，则总get数为W + W - D次");
        println("在查找最大值阶段，对每一个单词，都调用两次get()进行比较，调用次数为2 * W");
        println("打印阶段，调用一次get()获取最大数");
        println("总get数为4 * W - D+ 1次");
    }
}