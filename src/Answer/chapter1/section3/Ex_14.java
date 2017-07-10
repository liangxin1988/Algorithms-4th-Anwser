package Answer.chapter1.section3;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import queue.ResizingArrayQueueOfStrings;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_14 extends Answer0 {
    @Override
    public void answer() {
        ResizingArrayQueueOfStrings resizingArrayQueueOfStrings = new ResizingArrayQueueOfStrings();
        for(int i = 0;i<10;i++){
            boolean bool = StdRandom.bernoulli();
            println(bool?"入列:"+i:"出列");
            if(bool){
                resizingArrayQueueOfStrings.enqueue(""+i);
            }else if(!resizingArrayQueueOfStrings.isEmpty()){
                resizingArrayQueueOfStrings.dequeue();
            }
            println(resizingArrayQueueOfStrings);
        }
    }
}
