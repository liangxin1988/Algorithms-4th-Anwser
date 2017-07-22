package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.linked.SimpleLinked;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_19 extends Answer0 {
    @Override
    public void answer() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = 0;i<3;i++){
            simpleLinked.addFirst(i);
        }
        println(simpleLinked);
        for(int i = 0;i<3;i++){
            simpleLinked.deleteLast();
            println(simpleLinked);
        }
    }
}
