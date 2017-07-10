package Answer.chapter1.section3;

import Answer.base.Answer1String;
import edu.princeton.cs.algs4.Stack;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_9 extends Answer1String {
    @Override
    public void answer() {
        String str = getArgs1();
        Checker.checkStringNull(str);
        Stack<String> result = new Stack<>();  //用来保存结果，其中的每一个元素是一个运算因子（如数字3或者已经拼接好的算式（3 + 4），或者单独的运算符）
        for(char s : str.toCharArray()){
            switch(s){
                case ')':  //如果是右括号，要将之前的数据拼装为带左右括号的完整的算式
                    String c1 = "(";
                    Stack<String> c3 = new Stack<>();  //用这个栈调整result中弹出的元素的顺序（由于第一次入栈是正序，导致弹出时为倒序，需要调整为正序后再入栈）
                    for(int i = 0;i<3;i++){  //取出最后入栈的3个因式（两个因式和一个运算符），拼接到c1中
                        c3.push(result.pop());
                    }
                    while(!c3.isEmpty()){
                        c1 += c3.pop();
                    }
                    c1 += ")";
                    result.push(c1);  //将拼接完整的因式封装为栈推入result栈
                    break;
                default:  //如果是普通字符，直接存入result栈
                    result.push(s + "");
                    break;
            }
//			println(result);  //打印轨迹
        }
//		Stack<String> hehe = new Stack<>();  //由于因式间是倒序排列的，所以需要定义另一个栈，使栈中的元素可以倒序排列。这个步骤其实没必要存在—_-!!
//		while(!result.isEmpty()){
//			hehe.push(result.pop().toString());
//		}
        println(result);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"1+2)*3-4)*5-6)))"};  //为了解析方便，所有数字为1位数，中间不允许有空格（方便通过控制台传参）
    }
}
