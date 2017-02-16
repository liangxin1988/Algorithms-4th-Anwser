package chapter1;

import static edu.princeton.cs.algs4.StdOut.println;
import Answer.BaseChapter;
import framework.Title;

public class Chapter1_1Creative extends BaseChapter{
	
	@Title("1.1.26")
	public static void question26(){
		println("int a = 4,b = 2,c = 6,t;");
		println("if(a > b){t = a;a = b;b = t;}  //此次步骤结束后,a必然小于等于b");
		println("if(a > c){t = a;a = c;c = t;}  //结束后，a小于等于c。此时可以确定a为最小（小于b且小于c）");
		println("if(b > c){t = b;b = c;c = t;}  //b小于等于c，排序结束");
	}
}
