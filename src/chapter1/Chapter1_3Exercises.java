package chapter1;

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
