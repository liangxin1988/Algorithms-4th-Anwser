package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.queue.RandomQueue;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_36 extends Answer0 {
    @Override
    public void answer() {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        for(int i = 0;i<10;i++){
            randomQueue.enqueue(i);
        }
        println(randomQueue);
    }
}
