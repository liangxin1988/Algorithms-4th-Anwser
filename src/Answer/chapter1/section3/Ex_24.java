package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.linked.SimpleLinked;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_24 extends Answer0 {
    @Override
    public void answer() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = 0;i<5;i++){
            simpleLinked.addFirst(i);
        }
        println(simpleLinked);
        simpleLinked.removeAfter(simpleLinked.getItemForIndex(2));  //会把2以后的元素都删除
        println(simpleLinked);
        simpleLinked.removeAfter(simpleLinked.getFirst());  //把除first的元素都删除
        println(simpleLinked);

    }
}
