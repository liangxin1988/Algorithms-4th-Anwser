package util;

import static edu.princeton.cs.algs4.StdOut.println;

import java.awt.Color;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 定义习题中，所有通用的方法
 * */
public class ChapterUtil {

	//可复用的StringBuilder
	private static StringBuilder sb;
	
	/**
	 * 获取一个可用的StringBuilder
	 * */
	public static StringBuilder getStringBuilder(){
		if(sb == null){
			sb = new StringBuilder();
		}else{
			sb.delete(0, sb.length());
		}
		return sb;
	}
	
	public static StringBuilder getStringBuilder(String str){
		return getStringBuilder().append(str);
	}
	/**
	 * 用随机数初始化int类型数组（x为随机限制的最大int值）
	 * */
	public static void initRandomArray(int[] ints, int x){
		for(int i = 0;i<ints.length;i++){
			ints[i] = StdRandom.uniform(x);
		}
	}

	/**
	 * 用随机数初始化double类型的数组
	 * */
	public static void initRandomArray(double[] doubles){
		for(int i = 0;i<doubles.length;i++){
			doubles[i] = StdRandom.uniform();
		}
	}

	/**
	 * 获取一个用随机数填充的数组
	 * @param size 数组尺寸
	 * */
	public static double[] getRandomArray(int size){
		double[] doubles = new double[size];
		initRandomArray(doubles);
		return doubles;
	}
	
	/**
	 * 在一些需要格式化的操作中，快速获得由count个空格组成的字符串
	 * */
	public static String getEmptyChar(int count){
		return getMutChar(count,' ');
	}

	/**
	 * 在一些需要格式化的操作中，快速获得由count个给定字符组成的字符串
	 * */
	public static String getMutChar(int count,char c){
		StringBuilder sb = getStringBuilder();
		for(int i = 0;i<count;i++){
			sb.append(c);
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
	
	/**
	 * 获取一个随机的颜色，用来在界面上对每一组数据进行区分
	 * */
	public static Color getRandomColor(){
		int a = StdRandom.uniform(256),b = StdRandom.uniform(256),c = StdRandom.uniform(256);
		return new Color(a,b,c);
	}

	/**打印一个二维数组*/
	public static void printArray(double[][] arr){
		if(arr == null || arr.length == 0){
			println("null");
		}
		for(int i = 0;i< arr.length;i++){
			println(Arrays.toString(arr[i]));
		}
	}

	public static void printArray(double[] arr){
		println(Arrays.toString(arr));
	}
}
