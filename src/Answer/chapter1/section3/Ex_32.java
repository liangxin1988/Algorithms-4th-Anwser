package Answer.chapter1.section3;

import Answer.base.Answer0;
import linked.LinkedSteque;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_32 extends Answer0 {
    @Override
    public void answer() {
        LinkedSteque<Integer> steque = new LinkedSteque<>();
        println("入栈测试:");
        for(int i = 0;i<4;i++){
            steque.push(i);
        }
        println(steque);
        for(int i = 0;i<4;i++){
            print(steque.pop() + "  ");
        }
        println();
        println("入列测试：");
        for(int i = 0;i<4;i++){
            steque.enqueue(i);
        }
        println(steque);
        for(int i = 0;i<4;i++){
            print(steque.pop() + "  ");
        }
        println();
    }
}