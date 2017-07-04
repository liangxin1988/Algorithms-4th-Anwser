package chapter1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import edu.princeton.cs.algs4.StdRandom;
import framework.Fixme;
import queue.FixedLengthQueue;
import queue.ResizingArrayQueueOfStrings;
import stack.FixedCapacityStackOfStrings;
import util.ChapterUtil;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ResizingArrayQueue;
import edu.princeton.cs.algs4.Stack;
import framework.Title;
import Answer.BaseChapter;
import static edu.princeton.cs.algs4.StdOut.*;

/**
 * 1.3小节测试题
 * */
public class Chapter1_3Exercises  extends BaseChapter{

	@Title("1.3.1")
	public static void question1(){
		FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(5);  //最多存储5个
		while(!fixedCapacityStackOfStrings.isFull()){  //通过isFull标记，将数据存满
			fixedCapacityStackOfStrings.push("test");
		}
		println("size = "+fixedCapacityStackOfStrings.size());  //打印size，看是否与设置的5一致。
	}
	
	@Title("1.3.2")
	public static void question2(String s){
		if(s == null){
			s = "it was - the best - of times - - - it was - the - -";
		}
		FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(1100);
		String[] strs = s.split(" ");
		for(String str : strs){
			if(str.equals("-")){
				fixedCapacityStackOfStrings.pop();
			}else if(str.equals("*")){  //为了复用这段代码实现第3题增加*号标记。其含义是出栈并打印。
				print(fixedCapacityStackOfStrings.pop()+"  ");
			}else{
				fixedCapacityStackOfStrings.push(str);
			}
//			println(fixedCapacityStackOfStrings);  //打印轨迹
		}
		println(fixedCapacityStackOfStrings);
	}
	
	@Title("1.3.3")
	public static void question3(){
		//通过题目2中的语法规则模拟出入栈规则（如果有）或者近似规则。其中数字表示入栈，*表示出栈并打印。
		print("a可以实现    :  ");question2("0 1 2 3 4 * * * * * 5 6 7 8 9 * * * * *");
		print("b无法实现    :  ");question2("0 1 2 3 4 * 5 6 * 7 8 * * * * * 9 * * *");  //0比1早入栈，所以0不能比1早出栈
		print("c可以实现    :  ");question2("0 1 2 * 3 4 5 * 6 * 7 * * 8 * 9 * * * *");
		print("d可以实现    :  ");question2("0 1 2 3 4 * * * * * 5 * 6 * 7 * 8 * 9 *");
		print("e可以实现    :  ");question2("0 1 * 2 * 3 * 4 * 5 * 6 * 7 8 9 * * * *");
		print("f无法实现    :  ");question2("0 * 1 2 3 4 * 5 6 * * * 7 8 * * * 9 * *");  //7比1晚入栈，所以7必须在1出栈前出栈
		print("g无法实现    :  ");question2("0 1 * 2 3 4 * 5 6 7 * 8 9 * * * * * * *");  //与b类似
		print("h可以实现    :  ");question2("0 1 2 * * 3 4 * * 5 6 * * 7 8 * * 9 * *");
	}
	
	@Title("1.3.4")
	public static void question4(String str){
		if(str == null){
			str = "[()]{}{[()()]()}";
		}
		boolean result = true;
		FixedCapacityStackOfStrings parentheses = new FixedCapacityStackOfStrings(100);
		outer:
		for(char c : str.toCharArray()){
			switch(c){
			case '[':case '(':case '{':
				parentheses.push(""+c);
				break;
			case ']':
				if(!parentheses.pop().equals("[")){  //右括号的顺序应该与出栈顺序一致，不一致说明不匹配
					result = false;
					break outer;
				}
				break;
			case ')':
				if(!parentheses.pop().equals("(")){  //右括号的顺序应该与出栈顺序一致，不一致说明不匹配
					result = false;
					break outer;
				}
				break;
			case '}':
				if(!parentheses.pop().equals("{")){  //右括号的顺序应该与出栈顺序一致，不一致说明不匹配
					result = false;
					break outer;
				}
				break;
			}
//			println(parentheses);  //打印轨迹
		}
		if(result){ //如果没发现不匹配的现象，则需要再次检查数量是否可以对应。如果完整匹配，所有左括号应该都出栈完毕
			result = parentheses.size() == 0; 
		}
		println(result);
	}
	
	@Title("1.3.5")
	public static void question5(){
		ChapterUtil.questionLue();
	}
	
	@Title("1.3.6")
	public static void question6(){
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
	
	@Title("1.3.7")
	public static void question7(){
		FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(5);
		fixedCapacityStackOfStrings.push("1");
		fixedCapacityStackOfStrings.push("2");
		println(fixedCapacityStackOfStrings);
		println("返回最近添加的值："+fixedCapacityStackOfStrings.peek()+",但是不弹出");
		println(fixedCapacityStackOfStrings);  //打印发现与peek前没有变化
		println("返回最近添加的值："+fixedCapacityStackOfStrings.pop()+",并弹出");
		println(fixedCapacityStackOfStrings);  //pop后元素变少了
	}
	
	@Title("1.3.8")
	public static void question8(){
		//DoublingStackOfStrings 是什么鬼?书里有么？
		ChapterUtil.questionNo();
	}
	
	@Title("1.3.9")
	public static void question9(String str){
		if(str == null){
			str = "1+2)*3-4)*5-6)))";  //为了解析方便，所有数字为1位数，中间不允许有空格（方便通过控制台传参）
		}
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
	
	@Title("1.3.10")
	public static void question10(String str){
		if(str == null){
			str = "((1+2)*((3-4)*(5-6)))";  //与1.3.9要求一致
		}
		println(new InfixToPostfix(str).execute());
	}
	
	@Title("1.3.11")
	public static void question11(String str){
		if(str == null){
			str = "((12+)((34-)(96-)*)*)";
		}
		println(EvaluatePostfix.execute(str));
	}
	
	@Title("1.3.12")
	public static void question12(){
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
	
	@Title("1.3.13")
	public static void question13(){
		print("a可以实现    ：    ");queueTest("0 1 2 3 4 5 6 7 8 9 * * * * * * * * * *"); 
		println("剩下的都不能实现。队列出栈的结果只有可能为a一种情况");
	}
	
	@Title("1.3.14")
	public static void question14(){
        ResizingArrayQueueOfStrings resizingArrayQueueOfStrings = new ResizingArrayQueueOfStrings();
        for(int i = 0;i<10;i++){
            boolean bool = StdRandom.bernoulli();
            println(bool?"入列:"+i:"出列");
            if(bool){
                resizingArrayQueueOfStrings.enqueue(""+i);
            }else if(!resizingArrayQueueOfStrings.isEmpty()){
                resizingArrayQueueOfStrings.dequeue();
            }
            println(resizingArrayQueueOfStrings);
        }
	}

	@Title("1.3.15")
	public static void question15(String args1,String args2){
		int count = 5;
		String[] array = new String[20];
		if(args1 != null){
			count = Integer.parseInt(args1);
		}
		if(args2 != null){
			array = args2.split(",");
		}else{
			for(int i = 0;i<array.length;i++){
				array[i] = i + "";
			}
		}
		FixedLengthQueue<String> fixedLengthQueue = new FixedLengthQueue<String>(count);
		for(String s : array){
			fixedLengthQueue.enqueue(s);
//			println(fixedLengthQueue);  //打印轨迹
		}
		println("倒数第"+count+"的元素为："+fixedLengthQueue.dequeue());
	}
	
	//1.3.13中使用的方法。与1.3.2用法一致，不过操作的是队列，- 和 * 表示出列。
	private static void queueTest(String s){
		if(s == null){
			s = "it was - the best - of times - - - it was - the - -";
		}
		Queue<String> queue = new Queue<>();
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



/**
 * 1.3.10题目要求的过滤器
 * 将中序表达式转换为后序表达式的工具类（表达式必须拥有完整的括号）
 * */
class InfixToPostfix{
	private String str;
	public InfixToPostfix(String str){
		this.str = str;
	}

	public String execute(){
		return getPostfix(str);
	}

	/**
	 * 给出一个两边带括号的中序表达式，返回一个两边带括号的后序表达式
	 * */
	private String getPostfix(String str){
		if(!str.startsWith("(")){  //不是表达式，直接返回
			return str;
		}

		str = str.substring(1,str.length() - 1);//去掉首尾的括号，方便后续解析
		String start,end;  //每个表达式都有唯一的运算符（子表达式中的运算符不算，如((1+2)*4)中，只有*号算运算符），将运算符前半部分和后半部分拆为start和end
		int index = -1;  //保存当前表达式中运算符的位置

		Stack<Integer> opt = new Stack<>();
		char[] chars = str.toCharArray();
		for(int i = 0;i<chars.length;i++){  //遇到符号入栈，遇到右括号出栈，这样保证循环完毕后栈中只有一个运算符，即表达式的运算符
			switch (chars[i]) {
				case '+':case '-':case '*':case '/':
					opt.push(i);
					break;
				case ')':
					opt.pop();
					break;
				default:
					break;
			}
//				println("stack = "+opt);  //打印轨迹
		}
		index = opt.pop();  //注意：这里用了最容易理解的机制找index，缺点是每次递归都要遍历字符串。其实可以考虑用一次遍历找到所有符号位，有兴趣的小伙伴可以优化一下
		start = str.substring(0,index);  //以运算符为分界，将左右部分进行切割
		end= str.substring(index + 1,str.length());

		start = getPostfix(start);  //左右两部分有可能也是表达式，通过递归将子表达式拼接为后序表达式
		end = getPostfix(end);
		return "("+start+end+str.charAt(index)+")";  //将括号拼接回来，并将括号中的字符拼接为后序表达式。
	}

}

/**
 * 1.3.11中要求的过滤器
 * 对后序表达式进行求值，似乎比中序表达式求值简单，没加注释
 * */
class EvaluatePostfix{
	public static double execute(String str){
		Stack<Double> num = new Stack<>();

		for(char c : str.toCharArray()){
			double a = 0,b = 0;
			switch (c) {
				case '+':
					num.push(num.pop() + num.pop());
					break;
				case'-':
					a = num.pop();
					b = num.pop();
					num.push(b - a);
					break;
				case'*':
					num.push(num.pop() * num.pop());
					break;
				case'/':
					a = num.pop();
					b = num.pop();
					num.push(b / a);
					break;
				case ')':case ' ':case '(':
					break;
				default:
					num.push(Double.parseDouble(c+""));
					break;
			}
		}
		return num.pop();
	}
}