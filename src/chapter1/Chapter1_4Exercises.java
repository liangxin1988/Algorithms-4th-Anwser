package chapter1;

import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;


public class Chapter1_4Exercises {

	public static void question1(){
		ChapterUtil.questionNo();  //暂时忽略
		println("记从N个数中取出m个数的不同组合数为c(N,m)，则本题要求证明c(N,3) = N(N -1)(N - 2)/6。");
		println("从3个数字中取出3个数字的取法只有一种，即c(3,3) = 1 = 3(3 - 1)(3 - 2)/6");
	}
}
