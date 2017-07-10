package Answer.chapter1.section3;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import linked.MoveToFront;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_40 extends Answer0 {
    @Override
    public void answer() {
        MoveToFront<Integer> moveToFront = new MoveToFront<>();
        for(int i = 0;i<20;i++){
            int uniform = StdRandom.uniform(10);
            moveToFront.insert(uniform);
            print("插入数据"+uniform+"后得到:");
            println(moveToFront);
        }
    }
}