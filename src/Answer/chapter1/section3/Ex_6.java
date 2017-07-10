package Answer.chapter1.section3;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_6 extends Answer0 {
    @Override
    public void answer() {
        println("倒序排列");
        Stack<String> stack = new Stack<String>();
        Queue<String> q = new Queue();
        for(int i = 0;i<9;i++){
            q.enqueue(i + "");
        }
        println("操作前："+q);
        while(!q.isEmpty()){
            stack.push(q.dequeue());  //由于栈的后进先出特性，使得栈可以用来进行倒序输出
        }
        while(!stack.isEmpty()){
            q.enqueue(stack.pop());
        }
        println("操作后："+q);
    }
}
