package chapter1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import framework.Title;
import Answer.BaseChapter;
import Answer.ChapterUtil;
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
		//a
		FixedCapacityStackOfStrings a = new FixedCapacityStackOfStrings(10);
		print("a可以实现    :  ");question2("0 1 2 3 4 * * * * * 5 6 7 8 9 * * * * *");
		//b
		FixedCapacityStackOfStrings b = new FixedCapacityStackOfStrings(10);
		print("b无法实现    :  ");question2("0 1 2 3 4 * 5 6 * 7 8 * * * * * 9 * * *");  //0比1早入栈，所以0不能比1早出栈
		//c
		FixedCapacityStackOfStrings c = new FixedCapacityStackOfStrings(10);
		print("c可以实现    :  ");question2("0 1 2 * 3 4 5 * 6 * 7 * * 8 * 9 * * * *");
		//d
		FixedCapacityStackOfStrings d = new FixedCapacityStackOfStrings(10);
		print("d可以实现    :  ");question2("0 1 2 3 4 * * * * * 5 * 6 * 7 * 8 * 9 *");
		//e
		FixedCapacityStackOfStrings e = new FixedCapacityStackOfStrings(10);
		print("e可以实现    :  ");question2("0 1 * 2 * 3 * 4 * 5 * 6 * 7 8 9 * * * *");
		//f
		FixedCapacityStackOfStrings f = new FixedCapacityStackOfStrings(10);
		print("f无法实现    :  ");question2("0 * 1 2 3 4 * 5 6 * * * 7 8 * * * 9 * *");  //7比1晚入栈，所以7必须在1出栈前出栈
		//g
		FixedCapacityStackOfStrings g = new FixedCapacityStackOfStrings(10);
		print("g无法实现    :  ");question2("0 1 * 2 3 4 * 5 6 7 * 8 9 * * * * * * *");  //与b类似
		//h
		FixedCapacityStackOfStrings h = new FixedCapacityStackOfStrings(10);
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
		//DoublingStackOfStrings ?
		ChapterUtil.questionNo();
	}
	
	@Title("1.3.9")
	public static void question9(String str){  //这个题好难，做出来了但是没有充分测试也没啥把握，大家帮忙多给些用例测试一下吧
		if(str == null){
			str = "1+2)*3-4)*5-6)))";  //为了解析方便，所有数字为1位数
		}
		Stack<Stack<String>> result = new Stack<>();  //用来保存结果，其中的每一个栈是一个运算因子（如数字3或者已经拼接好的算式（3 + 4））
		for(char s : str.toCharArray()){
			switch(s){
			case ')':  //如果是右括号，要将之前的数据拼装为完整的算式
				Stack<String> c1 = new Stack<>();
				c1.push(")");
				for(int i = 0;i<3;i++){  //取出最后入栈的3个因式（两个因式和一个运算符），入临时栈c1
					Stack<String> c3 = result.pop();
					while(!c3.isEmpty()){
						c1.push(c3.pop());
					}
				}
				c1.push("(");  //加入左括号，拼接成完整的因式
				Stack<String> c4 = new Stack<>();
				c4.push(c1.toString());
				result.push(c4);  //将拼接完整的因式封装为栈推入result栈
				break;
			default:  //如果是普通字符，将字符包装为栈存入result栈中
				Stack<String> c2 = new Stack<>(); 
				c2.push(s + "");
				result.push(c2);
				break;
			}
//			println(result);  //打印轨迹
		}
		Stack<String> hehe = new Stack<>();  //由于隐式间是倒序排列的，所以需要定义另一个栈，使栈中的元素可以倒序排列
		while(!result.isEmpty()){
			hehe.push(result.pop().toString());
		}
		println(hehe);
	}
	
	public static class FixedCapacityStackOfStrings{
		private String[] a;
		private int N;
		public FixedCapacityStackOfStrings(int cap){
			a = new String[cap];
		}
		public boolean isEmpty(){
			return N == 0;
		}
		public int size(){
			return N;
		}
		public void push(String item){
			a[N++] = item;
		}
		public String pop(){
			return a[--N];
		}
		
		public boolean isFull(){
			return N == a.length;  //当N等于a.length时，就无法通过a[N]访问元素了，此时数组已经没有空位
		}
		
		/**
		 * 返回最近添加的元素，而不弹出
		 * */
		public String peek(){
			return a[N - 1];  //与pop相比，不修改N的值，即可实现不弹出
		}
		
		@Override
		public String toString() {
			if(isEmpty()){
				return "";
			}
			StringBuilder sb = new StringBuilder();
			sb.append("");
			for(int i = 0;i<N;i++){
				sb.append(a[i]).append(",");
			}
			sb.replace(sb.length()-1, sb.length(), "");
			return sb.toString();
		}
	}
}
