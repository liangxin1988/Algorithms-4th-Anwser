package Answer.chapter1.section3;

import Answer.base.Answer0;
import linked.SimpleLinked;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_26 extends Answer0 {
    @Override
    public void answer() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        for(int i = 0;i<11;i++){
            if(i % 2 == 0){
                simpleLinked.addFirst(1);
            }else{
                simpleLinked.addFirst(i / 2);
            }
        }
        println(simpleLinked);
        simpleLinked.removeForKey(1);
        println(simpleLinked);

        simpleLinked.clearLink();
        for(int i = 0;i<10;i++){
            simpleLinked.addFirst(1);
        }
        println(simpleLinked);
        simpleLinked.removeForKey(1);
        println(simpleLinked);
    }
}
