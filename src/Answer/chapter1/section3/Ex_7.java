package Answer.chapter1.section3;

import Answer.base.Answer0;
import stack.FixedCapacityStackOfStrings;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_7 extends Answer0 {
    @Override
    public void answer() {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(5);
        fixedCapacityStackOfStrings.push("1");
        fixedCapacityStackOfStrings.push("2");
        println(fixedCapacityStackOfStrings);
        println("返回最近添加的值："+fixedCapacityStackOfStrings.peek()+",但是不弹出");
        println(fixedCapacityStackOfStrings);  //打印发现与peek前没有变化
        println("返回最近添加的值："+fixedCapacityStackOfStrings.pop()+",并弹出");
        println(fixedCapacityStackOfStrings);  //pop后元素变少了

    }
}
