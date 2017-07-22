package Answer.chapter1.section3;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import data_structure.queue.CircularLinkedQueue;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_29 extends Answer0 {
    @Override
    public void answer() {
        CircularLinkedQueue<Integer> circularLinkedQueue = new CircularLinkedQueue<>();
        for(int i = 0;i<20;i++){
            circularLinkedQueue.enqueue(i);
            if(StdRandom.bernoulli())
                println("出列:"+circularLinkedQueue.dequeue());
            println(circularLinkedQueue);  //打印轨迹
        }
    }
}