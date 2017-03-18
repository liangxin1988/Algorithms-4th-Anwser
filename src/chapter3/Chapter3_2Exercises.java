package chapter3;

import edu.princeton.cs.algs4.StdRandom;
import framework.Title;
import st.BST;
import Answer.BaseChapter;

public class Chapter3_2Exercises extends BaseChapter {

	@Title("3.2.2")
	public static void question2(){
		
		String example = "AXCSERH";
		int bad = getHeight(example);  //最坏情况下高度为7
		System.out.println("bad is "+bad);
		String test1 = "ACEHRSX";
		System.out.println("test1's height is"+getHeight(test1));
		String test2 = "XSRHECA";
		System.out.println("test2's height is"+getHeight(test2));
		String test3 = "ACEXSRH";
		System.out.println("test3's height is"+getHeight(test3));
		String test4 = "ACXSRHE";
		System.out.println("test4's height is"+getHeight(test4));
		String test5 = "ACEHRXS";
		System.out.println("test5's height is"+getHeight(test5));
	}
	
	@Title("3.2.3")
	public static void question3(){
		String test1 = "HCSAERX";
		System.out.println("test1's height is"+getHeight(test1));
		String test2 = "HCASEXR";
		System.out.println("test2's height is"+getHeight(test2));
		String test3 = "HSCRXAE";
		System.out.println("test3's height is"+getHeight(test3));
		String test4 = "HSCXREA";
		System.out.println("test4's height is"+getHeight(test4));
		String test5 = "HCSEAXR";
		System.out.println("test5's height is"+getHeight(test5));
	}
	
	@Title("3.2.6")
	public static void question6(){
		int[] cs = {1,2,3,4,5,6,7,8,9,0};
		for(int i = 0;i<100;i++){
			StdRandom.shuffle(cs);
			BST<Integer, Integer> st = new BST<>();
			for(int j = 0;j<cs.length;j++){
				st.put(cs[j], cs[j]);
			}
			if(st.height1() != st.height2()){
				System.out.println("wrong");
			}
		}
		System.out.println("over");
	}
	
	private static int getHeight(String str){
		BST<String,Integer> st = new BST<>();
		for(char c : str.toCharArray()){
			st.put(c+"",0);
		}
		return st.height();
	}
}
