package Answer.chapter1.section3;

import Answer.base.Answer0;
import Answer.base.Answer2Integer;
import queue.JsephusQueue;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_37 extends Answer2Integer {
    @Override
    public void answer() {
        int m = getArgs1(),n = getArgs2();
        Checker.checkPlus(m,n);
        JsephusQueue<Integer> jsephusQueue = new JsephusQueue<>(m);
        for(int i = 0;i < n;i++){  //将n个人入列（按顺序排好）
            jsephusQueue.enqueue(i);
        }
        while(!jsephusQueue.isEmpty()){  //将所有人出列，出列的顺序即为被杀死的人的顺序
            print(jsephusQueue.dequeue()+"  ");
        }
        println();
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{2,7};
    }
}