package Answer.chapter2.section5;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_1 extends Answer0{
    @Override
    public void answer() {
        println("由于java中的String类是不可变类，而且具有复用的特性（如果两个字符串的内容一样，那么两个字符串的地址很可能也一样），所以可以使用==判断两个字符串是否相等。这种判断效率非常高");
    }
}
