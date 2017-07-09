package chapter1;
import static edu.princeton.cs.algs4.StdOut.*;

import java.util.Arrays;
import java.util.Scanner;

import util.ChapterUtil;

import edu.princeton.cs.algs4.StdRandom;

//完成
public class Chapter1_1Exercises {
	
	public static void question5(String a,String b){
		}
	
	public static void question6(){

	}
	
	public static void question7(){

	}
	
	public static void question8(){
		}
	
	public static void question9(){
		ChapterUtil.questionLue();
	}
	
	public static void question10(){
		ChapterUtil.questionLue();
	}
	
	public static void question11(){
		int line = 10;
		int column = 10;
		String format = "%2s";
		//初始化boolean数组
		boolean[][] a = new boolean[line][column];
		for(int i = 0;i<line;i++){
			for(int j = 0;j<column;j++){
				a[i][j] = StdRandom.bernoulli();
			}
		}
		for(int i = -1;i<line;i++){
			for(int j = -1;j<column;j++){
				if(i == -1){  //打印列号
					printf(format,j == -1?" ":""+j);
				}else if(j == -1){  //打印行号
					printf(format,""+i);
				}else{  //打印数组内容
					printf(format,a[i][j]?"*":" ");
				}
			}
			println();  //每一行结束要换行
		}
		
	}
	
	public static void question12(){
		int[] a = new int[10];
		for(int i = 0;i<10;i++)
			a[i] = 9 - i;
		for(int i = 0;i<10;i++)
			a[i] = a[a[i]];
		for(int i = 0;i<10;i++){
			println(a[i]);   //原题为i，不合理，这里应该是a[i]
		}
	}
	
	public static void question13(){
		String format = "%2d";
		int line = 3,column = 5;
		int[][] x = new int[line][column];
		for(int i = 0;i<line;i++){
			for(int j = 0;j<column;j++){
				x[i][j] = StdRandom.uniform(10);
			}
		}
		println("原数组");
		for(int i = 0;i<line;i++){
			for(int j = 0;j<column;j++){
				printf(format,x[i][j]);
			}
			println();
		}
		println("转置后的数组");
		for(int i = 0;i<column;i++){
			for(int j = 0;j<line;j++){
				printf(format,x[j][i]);
			}
			println();
		}
		
	}

	public static void question14(String num){
//		int a = StdRandom.uniform(100);
		int a = 9;
		if(num != null)
			a = Integer.parseInt(num);
//		println(Math.log(a) / Math.log(2));  //以2为底的对数，打开注释可作为对照
		int count = 0;
		for(int i = 1;i<=a;i*=2){
			count++;
		}
		println(count-1);
	}
	
	public static void question15(String numStr){
		int num = 5;
		if(numStr != null){
			num = Integer.parseInt(numStr);
		}
		int[] nums = new int[num * num];  //num * num没啥具体含义，就是想让元素个数多一些
		ChapterUtil.initRandomArray(nums, num);
		println("打印原始数组：");
		println(Arrays.toString(nums));
		println("打印统计数组");
		println(Arrays.toString(histogram(nums,num)));
	}

    /**1.1.15要求的方法*/
	private static int[] histogram(int[] a,int m){
	    int[] count = new int[m];
        for(int i : a){
            count[i]++;
        }
	    return count;
    }
	
	public static void question16(){
		println(exR1(6));  //311361142246
	}
	
	private static String exR1(int n){
		if (n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}
	
	public static void question17(){
		ChapterUtil.questionLue();
	}
	
	public static void question18(){
		println(mystery1(2,25));  //计算乘法
		println(mystery2(2,4));  //计算次方
	}
	
	public static void question19(){
		int x = 50;
		println("所需时间较长，请耐心等待");
		//粗略估算运行时间
		long time = System.currentTimeMillis();
		println(Fibonacci.F(x));
		println("使用时间："+(System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		println(FibonacciFaster.F(x));
		println("使用时间："+(System.currentTimeMillis() - time));
	}
	
	public static void question20(){
		int x = 10;
		println(Math.log(factorial(x)));
		println(lnFactorial(x));
	}
	
	public static void question21(){
		println("请输入数据\n");
		Scanner scanner = new Scanner(System.in);
		String format = "%10s%4d%4d%10.3f";
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			String[] strs = str.split(" ");
			int a = Integer.parseInt(strs[1]);
			int b = Integer.parseInt(strs[2]);
			printf(format, strs[0],a,b,a * 1.0 /b);
		}
	}
	
	public static void question22(){
		int a[] = {85,54,6,5,8,52,6,8,6,65,6,85,3};
		Arrays.sort(a);  //使用二分法查找前必须保证数组有序
		rankByLevel(52, a, 0, a.length - 1, 0);
	}
	
	public static void question23(String str){
		int a[] = {85,54,6,5,8,52,6,8,6,65,6,85,3};  //白名单
		int list[] = {85,54,6,35,8,52,26,8,6,365,6,85,3,56,654,6,46,5};  //测试数据
		char x = '-';
		if(str != null){
			char cacheChar = str.charAt(0);
			if(cacheChar == '-' || cacheChar == '+'){
				x = cacheChar;
			}
		}
		Arrays.sort(a);  //二分法查找前要保证数组有序
		for(int integer : list){
			int index = rank(integer,a);
			if(x == '+' && index == -1){
				print(integer + " ");
			}else if(x == '-' && index != -1){
				print(integer + " ");
			}
		}
		println();
	}
	
	public static void question24(String x1,String x2){
		int x = 1111111;
		int y = 1234567;
		if(x1 != null && x2 != null){
			x = Integer.parseInt(x1);
			y = Integer.parseInt(x2);
		}
		println(Euclid(x, y,0));
	}
	
	public static void question25(){
		ChapterUtil.questionNo();
	}

	/**1.1.24要求使用的可以打印参数的欧几里得算法版本*/
	private static int Euclid(int p, int q, int level){
		println(ChapterUtil.getEmptyChar(level)+"p = "+p+",q = "+q);
		if(q == 0) return p;
		int r = p % q;
		return Euclid(q,r,level + 1);
	}
	
	private static int rank(int key,int[] a){
		return rank(key,a,0,a.length - 1);
	}
	
	private static int rank(int key,int[] a,int lo,int hi){
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid]) return rank(key,a,lo,mid - 1);
		else if(key > a[mid]) return rank(key,a,mid + 1,hi);
		else return mid;
	}

	/**1.1.22题目要求的方法*/
	private static int rankByLevel(int key,int[] a,int lo,int hi,int level){
		println(ChapterUtil.getEmptyChar(level)+"lo = "+lo+",hi = "+hi);
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid]) return rankByLevel(key,a,lo,mid - 1,level + 1);
		else if(key > a[mid]) return rankByLevel(key,a,mid + 1,hi,level + 1);
		else return mid;
	}
	/**1.1.20中，計算阶乘的方法*/
	private static long factorial(int x){
		if(x == 1) return 1;
		return factorial(x - 1) * x;  //阶乘等于当前数乘以上一个数的阶乘
	}
	
	/**題目1.1.20中方法的另一個版本归计算阶乘对数*/
	private static double lnFactorial(int x){
		if(x == 1) return Math.log(1);
		return lnFactorial(x - 1) + Math.log(x);  //由于乘积的对数等于对数的和（log(a * b) == log(a) + log(b)），所以原题可以简化为递归计算对数和
	}

	/**1.1.18题目中使用的方法*/
	private static int mystery1(int a,int b){  //递归计算乘法
		if(b == 0){
			return 0;
		}
		if(b % 2 == 0){
			return mystery1(a+a, b / 2);  //将乘法转换为加法，将b的每一位取出，如果为0，不管。如果不为0，则计算当前位与a的乘积
		}
		return mystery1(a+a, b / 2) + a;  //每次返回的值中增加了a，a是此次递归时b的当前位与a的乘积，最后的结果就是所有不为0位的和。
	}

    /**1.1.18题目中使用的方法的改版*/
	private static int mystery2(int a,int b){
		if(b == 0){
			return 1;
		}
		if(b % 2 == 0){
			return mystery2(a*a, b / 2);  //与mystery1思想类似，将加法变为乘法，得到的结果是将b个a相乘，及a的b次方。
		}
		return mystery2(a*a, b / 2) * a;
	}
}

/**1.1.19原题中的斐波那契计算类*/
class Fibonacci{
    static long F(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }
}
/**1.1.19中斐波那契计算类的优化版本通过数组缓存计算的中间结果*/
class FibonacciFaster{
    /**最为缓存使用的数组。为了简化操作，长度定为100*/
    static long cache[] = new long[100];
    static long F(int N){
        if(N >= 100){
            throw new RuntimeException("请输入0 ~ 99的整数");
        }
        if(N == 0) return 0;
        if(N == 1) return 1;
        if(cache[N] == 0){
            cache[N] =  F(N - 1) + F(N - 2);
        }
        return cache[N];
    }
}