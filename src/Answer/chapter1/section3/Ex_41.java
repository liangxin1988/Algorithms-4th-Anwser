package Answer.chapter1.section3;

import Answer.base.Answer0;
import queue.CircularLinkedQueue;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_41 extends Answer0 {
    @Override
    public void answer() {
        CircularLinkedQueue<Integer> circularLinkedQueue = new CircularLinkedQueue<Integer>();
        for(int i = 0;i<10;i++){
            circularLinkedQueue.enqueue(i);
        }
        CircularLinkedQueue<Integer> newQueue = new CircularLinkedQueue<>(circularLinkedQueue);
        print("原队列:");println(circularLinkedQueue);
        print("新队列:");println(newQueue);
    }
}