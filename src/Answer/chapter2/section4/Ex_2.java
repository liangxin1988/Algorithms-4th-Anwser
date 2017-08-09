package Answer.chapter2.section4;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_2 extends Answer0{
    @Override
    public void answer() {
        println("如果只保存一个max，那么只能获取一次最大，删除最大元素后再次调用会返回错误的结果");
        println("如果使用多个字段，那么每次插入还要把新元素插入到已经保存的多个元素中，相当于进行插入排序，而且还要额外处理删除的情况");
    }
}
