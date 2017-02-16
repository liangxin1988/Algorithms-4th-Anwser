package Answer;

import static edu.princeton.cs.algs4.StdOut.println;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 定义习题中，所有通用的方法
 * */
public class ChapterUtil {

	//可复用的StringBuilder
	private static StringBuilder sb = new StringBuilder();
	/**
	 * 用随机数初始化int类型数组（x为随机限制的最大int值）
	 * */
	public static void initArray(int[] ints,int x){
		for(int i = 0;i<ints.length;i++){
			ints[i] = StdRandom.uniform(x);
		}
	}
	
	/**
	 * 在一些需要格式化的操作中，快速获得由count个空格组成的字符串
	 * */
	public static String getEmptyChar(int count){
		sb.delete(0, sb.length());
		for(int i = 0;i<count;i++){
			sb.append(" ");
		}
		return sb.toString();
	}
	
	/**
	 * 原书中包含答案，忽略掉的问题
	 * */
	public static void questionLue(){
		println("原书中有，略");
	}
	
	/**
	 * 暂时不会的问题
	 * */
	public static void questionNo(){
		println("不会");
	}
}
