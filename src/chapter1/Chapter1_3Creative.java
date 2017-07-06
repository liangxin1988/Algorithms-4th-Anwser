package chapter1;

import Answer.BaseChapter;
import framework.Title;
import linked.LinkedSteque;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 1.3提高题
 */
public class Chapter1_3Creative extends BaseChapter {

    @Title("1.3.32")
    public static void question32(){
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
