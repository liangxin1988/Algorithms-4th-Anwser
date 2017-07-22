package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.deque.Deque;
import data_structure.deque.DoubleLinkedDeque;
import data_structure.deque.ResizingArrayDeque;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_33 extends Answer0 {
    @Override
    public void answer() {
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