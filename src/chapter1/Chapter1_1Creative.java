package chapter1;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;
import Answer.BaseChapter;
import framework.Title;
import util.ChapterUtil;

import java.math.BigInteger;

public class Chapter1_1Creative extends BaseChapter{
	
	@Title("1.1.26")
	public static void question26(){
		println("int a = 4,b = 2,c = 6,t;");
		println("if(a > b){t = a;a = b;b = t;}  //此次步骤结束后,a必然小于等于b");
		println("if(a > c){t = a;a = c;c = t;}  //结束后，a小于等于c。此时可以确定a为最小（小于b且小于c）");
		println("if(b > c){t = b;b = c;c = t;}  //b小于等于c，排序结束");
	}

	@Title("1.1.27")
	public static void question27(){
		int N = 100,k = 50;
		double p = 0.25;
//		println(binomial(N,k,p));  //未优化版本时间执行时间灰常的长，所以这里只能将其注释
		println(binomialFaster(N,k,p));
		print("估计调用次数：");ChapterUtil.questionNo();
	}

	public static void question28(){

	}

	/**1.1.27中提供的二项分布方法*/
	private static double binomial(int N,int k,double p){
		if(N == 0 && k == 0) return 1.0;
		if(N < 0 || k < 0) return 0.0;
		return (1.0 - p) * binomial(N - 1,k,p) + p * binomial(N - 1,k - 1,p);
	}

	/**在binomialFaster方法中使用的缓存数据*/
	private static double[][] binomialFasterCache = new double[150][150];
	static{
		for(int i = 0;i<150;i++){
			for(int j = 0;j<150;j++){
				binomialFasterCache[i][j] = Double.MIN_VALUE;
			}
		}
	}
	/**1.1.27题目中要求的更好的实现*/
	private static double binomialFaster(int N,int k,double p){
		if(N == 0 && k == 0) return 1.0;
		if(N < 0 || k < 0) return 0.0;
		if(binomialFasterCache[N][k] == Double.MIN_VALUE){
			binomialFasterCache[N][k] =  (1.0 - p) * binomialFaster(N - 1,k,p) + p * binomialFaster(N - 1,k - 1,p);
		}
		return binomialFasterCache[N][k];
	}
}
