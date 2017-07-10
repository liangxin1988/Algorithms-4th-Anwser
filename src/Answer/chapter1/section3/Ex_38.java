package Answer.chapter1.section3;

import Answer.base.Answer0;
import queue.ArrayGeneralizedQueue;
import queue.GeneralizedQueue;
import queue.LinkedGeneralizedQueue;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_38 extends Answer0 {
    @Override
    public void answer() {
        testGeneralizedQueue(new ArrayGeneralizedQueue<>());
        println("----------------------------");
        testGeneralizedQueue(new LinkedGeneralizedQueue<>());
    }

    private static void testGeneralizedQueue(GeneralizedQueue<Integer> queue){
        for(int i = 0;i<10;i++){
            queue.insert(i);
        }
        println(queue);
        print("删除:"+queue.delete(3)+" : ");
        println(queue);
        print("删除:"+queue.delete(3)+" : ");
        println(queue);
        print("删除:"+queue.delete(5)+" : ");
        println(queue);
        print("删除:"+queue.delete(0)+" : ");
        println(queue);
        print("删除:"+queue.delete(5)+" : ");
        println(queue);
    }
}