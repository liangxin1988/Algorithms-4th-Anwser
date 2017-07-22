package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.queue.CircularLinkedQueue;
import data_structure.queue.QueueTestHelper;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_13 extends Answer0 {
    @Override
    public void answer() {
        print("a可以实现    ：    ");
        QueueTestHelper.queueTest("0 1 2 3 4 5 6 7 8 9 * * * * * * * * * *",new CircularLinkedQueue<>());
        println("剩下的都不能实现。队列出栈的结果只有可能为a一种情况");
    }
}
