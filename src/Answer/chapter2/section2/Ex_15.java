package Answer.chapter2.section2;

import Answer.base.Answer0;
import data_structure.queue.LinkedQueue;
import data_structure.queue.Queue;
import data_structure.queue.QueueUtil;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_15 extends Answer0 {
    @Override
    public void answer() {
        int[] array = ChapterUtil.getRandomIntArray(10);
        println(Arrays.toString(array));
        Queue<Queue<Integer>> queue = new LinkedQueue();
        for(int i : array){
            Queue<Integer> q = new LinkedQueue<>();
            q.enqueue(i);
            queue.enqueue(q);
        }
        while(queue.size() != 1){
            queue.enqueue(QueueUtil.mergeQueue(queue.dequeue(),queue.dequeue()));
        }
        println(queue.dequeue());
    }
}