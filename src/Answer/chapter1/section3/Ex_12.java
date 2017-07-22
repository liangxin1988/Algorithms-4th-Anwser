package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.stack.FixedCapacityStackOfStrings;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_12 extends Answer0 {
    @Override
    public void answer() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
        stack.push("java");
        stack.push("kotlin");
        stack.push("c++");
        stack.push("hehe");

        FixedCapacityStackOfStrings copy = FixedCapacityStackOfStrings.copy(stack);

        println("原栈:");
        for(String str : stack){
            print( str + "  ");
        }
        println();
        println("复制的栈:");
        for(String str : copy){
            print( str + "  ");
        }
        println();
    }
}
