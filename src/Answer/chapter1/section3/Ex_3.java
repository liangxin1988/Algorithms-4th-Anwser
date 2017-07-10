package Answer.chapter1.section3;

import Answer.base.Answer0;
import stack.FixedCapacityStackOfStrings;
import stack.StackTestHelper;

import static edu.princeton.cs.algs4.StdOut.print;

/**
 * Created by liangxin on 2017/7/10.
 */
public class Ex_3 extends Answer0 {
    @Override
    public void answer() {
        //通过题目2中的语法规则模拟出入栈规则（如果有）或者近似规则。其中数字表示入栈，*表示出栈并打印。
        print("a可以实现    :  ");testStack("0 1 2 3 4 * * * * * 5 6 7 8 9 * * * * *");
        print("b无法实现    :  ");testStack("0 1 2 3 4 * 5 6 * 7 8 * * * * * 9 * * *");  //0比1早入栈，所以0不能比1早出栈
        print("c可以实现    :  ");testStack("0 1 2 * 3 4 5 * 6 * 7 * * 8 * 9 * * * *");
        print("d可以实现    :  ");testStack("0 1 2 3 4 * * * * * 5 * 6 * 7 * 8 * 9 *");
        print("e可以实现    :  ");testStack("0 1 * 2 * 3 * 4 * 5 * 6 * 7 8 9 * * * *");
        print("f无法实现    :  ");testStack("0 * 1 2 3 4 * 5 6 * * * 7 8 * * * 9 * *");  //7比1晚入栈，所以7必须在1出栈前出栈
        print("g无法实现    :  ");testStack("0 1 * 2 3 4 * 5 6 7 * 8 9 * * * * * * *");  //与b类似
        print("h可以实现    :  ");testStack("0 1 2 * * 3 4 * * 5 6 * * 7 8 * * 9 * *");
    }

    private void testStack(String str){
        new StackTestHelper().stackTest(str,new FixedCapacityStackOfStrings(1000));
    }
}
