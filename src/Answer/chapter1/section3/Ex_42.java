package Answer.chapter1.section3;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import data_structure.stack.LinkedStack;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_42 extends Answer0 {
    @Override
    public void answer() {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        for(int i = 0;i<20;i++){
            boolean bernoulli = StdRandom.bernoulli();
            if(bernoulli){
                linkedStack.push(i);
            }else{
                if(!linkedStack.isEmpty()){
                    linkedStack.pop();
                }
            }
//            print(bernoulli?("push:"+i):("pop   "));println(linkedStack);  //打印轨迹
        }
        println("原始栈："+linkedStack);
        print("复制的栈："+new LinkedStack<Integer>(linkedStack));
    }
}