package queue;

import edu.princeton.cs.algs4.*;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 用来对队列进行辅助测试的工具类
 */
public class QueueTestHelper {
    public static void queueTest(String s,Queue<String> queue){
//        if(s == null){
//            s = "it was - the best - of times - - - it was - the - -";
//        }
        String[] strs = s.split(" ");
        for(String str : strs){
            if(str.equals("-")){
                queue.dequeue();
            }else if(str.equals("*")){  //为了复用这段代码实现第3题增加*号标记。其含义是出栈并打印。
                print(queue.dequeue()+"  ");
            }else{
                queue.enqueue(str);
            }
//			println(queue);  //打印轨迹
        }
        println(queue);
    }
}
