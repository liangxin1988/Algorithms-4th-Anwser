package Answer.chapter1.section3;

import Answer.base.Answer0;
import linked.SimpleLinked;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_25 extends Answer0 {
    @Override
    public void answer() {
        SimpleLinked<Integer> simpleLinked = createSimpleList(0,5);
        SimpleLinked<Integer> simpleLinked2 = createSimpleList(6,10);
        simpleLinked.insertAfter(simpleLinked.getFirst(), simpleLinked2.getFirst());
        println(simpleLinked);

        simpleLinked = createSimpleList(0,5);
        simpleLinked2 = createSimpleList(6,10);
        simpleLinked.insertAfter(simpleLinked.getLast(), simpleLinked2.getFirst());
        println(simpleLinked);

        simpleLinked = createSimpleList(0,5);
        simpleLinked2 = createSimpleList(6,10);
        simpleLinked.insertAfter(simpleLinked.getItemForIndex(3), simpleLinked2.getFirst());
        println(simpleLinked);
    }

    /**创建链表并填充测试数据*/
    private static SimpleLinked<Integer> createSimpleList(int start, int end){
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = start;i<=end;i++){
            simpleLinked.addFirst(i);
        }
        return simpleLinked;
    }
}
