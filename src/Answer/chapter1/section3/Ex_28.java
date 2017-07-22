package Answer.chapter1.section3;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import data_structure.linked.SimpleLinked;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_28 extends Answer0 {
    @Override
    public void answer() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = 0;i<10;i++){
            int rand = StdRandom.uniform(20);
            print(rand + "  ");
            simpleLinked.addFirst(rand);
        }
        println();
        println("最大值："+ simpleLinked.max(simpleLinked.getFirst()));
    }
}