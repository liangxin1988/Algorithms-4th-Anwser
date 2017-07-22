package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.linked.SimpleLinked;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_21 extends Answer0 {
    @Override
    public void answer() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = 0;i<5;i++){
            simpleLinked.addFirst(i);
        }
        println(simpleLinked);
        int curr = 4;
        println("链表中"+(simpleLinked.find(simpleLinked.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 6;
        println("链表中"+(simpleLinked.find(simpleLinked.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 0;
        println("链表中"+(simpleLinked.find(simpleLinked.getFirst(),curr)?"存在":"不存在")+curr);

    }
}
