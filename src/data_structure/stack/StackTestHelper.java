package data_structure.stack;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class StackTestHelper {
    public void stackTest(String command,Stack<String> stack){
        String[] strs = command.split(" ");
        for(String str : strs){
            if(str.equals("-")){
                stack.pop();
            }else if(str.equals("*")){  //为了复用这段代码实现第3题增加*号标记。其含义是出栈并打印。
                print(stack.pop()+"  ");
            }else{
                stack.push(str);
            }
//			println(data_structure.stack);  //打印轨迹
        }
        println(stack);
    }
}
