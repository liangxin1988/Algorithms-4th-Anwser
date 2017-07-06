package chapter1;

import Answer.BaseChapter;
import deque.Deque;
import deque.DoubleLinkedDeque;
import deque.ResizingArrayDeque;
import edu.princeton.cs.algs4.StdRandom;
import framework.Title;
import linked.LinkedSteque;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
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

    @Title("1.3.33")
    public static void question33(){
        println("双向链表实现的双向队列测试：");
        randomTestDeque(new DoubleLinkedDeque<Integer>());
        println("数组实现的双向队列测试：");
        randomTestDeque(new ResizingArrayDeque<Integer>());
    }

    /**1.3.33使用的，使用随机的方式对双向队列进行测试*/
    private static void randomTestDeque(Deque deque) {
        String str = "";
        String format = "%-10s:";
        for(int i = 0;i<20;i++){
            switch (StdRandom.uniform(100) % 4){
                case 0:
                    str = "pushLeft:"+i;
                    deque.pushLeft(i);
                    break;
                case 1:
                    str = "pushRight:"+i;
                    deque.pushRight(i);
                    break;
                case 2:
                    str = "popLeft";
                    if(!deque.isEmpty()){
                        deque.popLeft();
                    }
                    break;
                case 3:
                    str = "popRight";
                    if(!deque.isEmpty()){
                        deque.popRight();
                    }
                    break;
            }
            printf(format,str);println(deque);
        }
    }
}
