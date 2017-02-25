package chapter1;
import static edu.princeton.cs.algs4.StdOut.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import util.ChapterUtil;

import Answer.BaseChapter;

import edu.princeton.cs.algs4.StdRandom;
import framework.Title;

public class Chapter1_1Exercises extends BaseChapter{

	@Title("1.1.1")
	public static void question1(){
		print((0 + 15) / 2);  println("  整数运算，得到的结果依然为整数。小数部分被舍弃（不是四舍五入）");
		print(2.0e-6 * 100000000.1); println("  2.0e-6，表示2乘以10的-6次方，也就是2 * 0.000001");
		println(true && false || true && false);
	}
	
	@Title("1.1.2")
	public static void question2(){
		println((1 + 2.236) / 2);
		print(1 + 2 + 3 + 4.0);  println("  运算符运算结果的变量类型，与参与运算的所有变量中，等级最高的变量类型一致。所以这里的结果为10.0（double），而不是10（int）");
		println(4.1 >= 4);
		print(1 + 2 + "3");  println("  +运算符的运算顺序为从左到右，进行1 + 2时，得到结果3。将3 与 “3”相加时，会自动调用字符串连接方法，将两者拼接为字符串“33”");
	}
	
	@Title("1.1.3")
	public static void question3(String x,String y,String z){
		int a = 2,b = 2,c = 2;
		if(x != null){
			a = Integer.parseInt(x);
			b = Integer.parseInt(y);
			c = Integer.parseInt(z);
		}
		println(a == b && b == c?"equal":"not equal");
	}

	@Title("1.1.4")
	public static void question4(){
		println("if(a > b) then c = 0;   //java中没有then关键字，应该去掉");
		println("if a > b {c = 0;}  //if后面的判断条件，需要括号");
		println("if (a > b) c = 0;  //木有问题，if后面的代码块如果只有一句代码，则大括号可以省略");
		println("if (a > b) c = 0 else b = 0;  //if后面的代码块中，c = 0是一条语句。java中的所有语句必须以“;”结尾");
	}
	
	@Title("1.1.5")
	public static void question5(String a,String b){
		double num1 = Double.parseDouble(a);
		double num2 = Double.parseDouble(b);
		println(num1 > 0 && num1 < 1 && num2 > 0 && num2 < 1);
	}
	
	@Title("1.1.6")
	public static void question6(){
		int f = 0;
		int g = 1;
		for(int i = 0;i<=15;i++){
			println(f);  //斐波那契数列的前N(N为循环次数)个数
			f = f + g;  //每次循环，得到的是当前数的下一个数
			g = f - g;  //每次循环，得到的是上一次循环的f，也就是当前的数。
		}
	}
	
	@Title("1.1.7")
	public static void question7(){
		double t = 9.0;
		while(Math.abs(t - 9.0/t) > .001) //牛顿迭代法求平方根
			t = (9.0/t + t)/2.0;
		printf("%.5f\n",t);
		
		int sum1 = 0;
		for(int i = 1;i<1000;i++){  //外层循环执行999次
			for(int j = 0;j<i;j++){  //内层循环执行次数与i一致
				sum1++;
			}
		}
		println(sum1);  //执行次数为1，2，3...999的等差数列，使用等差数列求和公式可得答案
		
		int sum2 = 0;
		for(int i = 1;i<1000;i*=2){  //外层循环执行10次（2的10次方为1024，从i=1(2^0)一直执行到i=512(2^9)，一共10次）
			for(int j = 0;j<1000;j++){  //内层循环每次固定执行1000次。
				sum2++;
			}
		}
		println(sum2);  //内外层循环相乘，等于10000
		
	}
	
	@Title("1.1.8")
	public static void question8(){
		println('b');
		println('b'+'c');  //字符型变量，在java编译器中也是按照int类型来看待的，所以两个char相加，等价于两个char的ascii码相加，即98(b)+99(c)=197
		println((char)('a'+4));  //同上，char也可以直接与int相加，得到的结果再转为char，则表示了该结果通过ascii反查到的char
	}
	
	@Title("1.1.9")
	public static void question9(){
		ChapterUtil.questionLue();
	}
	
	@Title("1.1.10")
	public static void question10(){
		ChapterUtil.questionLue();
	}
	
	@Title("1.1.11")
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
					printf(format,i == -1?" ":""+i);
				}else{  //打印数组内容
					printf(format,a[i][j]?"*":" ");
				}
			}
			println();  //每一行结束要换行
		}
		
	}
	
	@Title("1.1.12")
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
	
	@Title("1.1.13")
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

	@Title("1.1.14")
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
	
	@Title("1.1.15")
	public static void question15(String numStr){
		int num = 10;
		if(numStr != null){
			num = Integer.parseInt(numStr);
		}
		int[] nums = new int[num * num];
		ChapterUtil.initArray(nums, num);
		int[] count = new int[num];
		for(int i = 0;i<nums.length;i++){
			count[nums[i]]++;
		}
		println(Arrays.toString(count));
	}
	
	@Title("1.1.16")
	public static void question16(){
		println(exR1(6));  //311361142246
	}
	
	private static String exR1(int n){
		if (n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}
	
	@Title("1.1.17")
	public static void question17(){
		ChapterUtil.questionLue();
	}
	
	@Title("1.1.18")
	public static void question18(){
		println(mystery1(2,25));  //计算乘法
		println(mystery2(2,4));  //计算次方
	}
	
	@Title("1.1.19")
	public static void question19(){
		int x = 50;
		fibonacci2Cache = new long[x + 1];
		System.out.println("所需时间较长，请耐心等待");
		//粗略估算运行时间
		long time = System.currentTimeMillis();
		println(fibonacci1(x));
		println("使用时间："+(System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		println(fibonacci2(x));
		println("使用时间："+(System.currentTimeMillis() - time));
	}
	
	@Title("1.1.20")
	public static void question20(){
		int x = 10;
		println(Math.log(factorial(x)));
		println(lnFactorial(x));
	}
	
	@Title("1.1.21")
	public static void question21(){
		println("请输入数据\n");
		Scanner scanner = new Scanner(System.in);
		String format = "%5s%4d%4d%6.3f";
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			String[] strs = str.split(" ");
			int a = Integer.parseInt(strs[1]);
			int b = Integer.parseInt(strs[2]);
			printf(format, strs[0],a,b,a * 1.0 /b);
		}
	}
	
	@Title("1.1.22")
	public static void question22(){
		int a[] = {85,54,6,5,8,52,6,8,6,65,6,85,3};
		Arrays.sort(a);
		rankByLevel(52, a, 0, a.length - 1, 0);
	}
	
	@Title("1.1.23")
	public static void question23(){
		int a[] = {85,54,6,5,8,52,6,8,6,65,6,85,3};
		int list[] = {85,54,6,35,8,52,26,8,6,365,6,85,3,56,654,6,46,5};
		char x = '-';
		Arrays.sort(a);
		for(int integer : list){
			int index = rank(integer,a);
			if(x == '+' && index != -1){
				print(integer + " ");
			}else if(x == '-' && index == -1){
				print(integer + " ");
			}
		}
	}
	
	@Title("1.1.24")
	public static void question24(){
		println(gcd(1111111,1234567,0));
	}
	
	@Title("1.1.25")
	public static void question25(){
		ChapterUtil.questionNo();
	}
	
	public static int gcd(int p,int q,int level){
		println(ChapterUtil.getEmptyChar(level)+"p = "+p+",q = "+q);
		if(q == 0) return p;
		int r = p % q;
		return gcd(q,r,level + 1);
	}
	
	public static int rank(int key,int[] a){
		return rank(key,a,0,a.length - 1);
	}
	
	public static int rank(int key,int[] a,int lo,int hi){
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid]) return rank(key,a,lo,mid - 1);
		else if(key > a[mid]) return rank(key,a,mid + 1,hi);
		else return mid;
	}
	
	public static int rankByLevel(int key,int[] a,int lo,int hi,int level){
		println(ChapterUtil.getEmptyChar(level)+"lo = "+lo+",hi = "+hi);
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid]) return rankByLevel(key,a,lo,mid - 1,level + 1);
		else if(key > a[mid]) return rankByLevel(key,a,mid + 1,hi,level + 1);
		else return mid;
	}
	//递归计算阶乘
	public static long factorial(int x){
		if(x == 1) return 1;
		return factorial(x - 1) * x;  //阶乘等于当前数乘以上一个数的阶乘
	}
	
	//递归计算阶乘对数
	public static double lnFactorial(int x){
		if(x == 1) return Math.log(1);
		return lnFactorial(x - 1) + Math.log(x);  //由于乘积的对数等于对数的和（log(a * b) == log(a) + log(b)），所以原题可以简化为递归计算对数和
	}
	
	//不带缓存的斐波那契数列
	private static long fibonacci1(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci1(n - 1) + fibonacci1(n - 2);
	}
	
	//带缓存的斐波那契数列
	private static long[] fibonacci2Cache;
	private static long fibonacci2(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(fibonacci2Cache[n] != 0) return fibonacci2Cache[n];  //如果之前保存过结果，则直接返回保存的结果，尽量避免进行递归运算。以空间换时间
		return fibonacci2Cache[n] = fibonacci2(n - 1) + fibonacci2(n - 2);  //将结果进行保存。
	}
	
	private static int mystery1(int a,int b){  //递归计算乘法
		if(b == 0){
			return 0;
		}
		if(b % 2 == 0){
			return mystery1(a+a, b / 2);  //将乘法转换为加法，将b的每一位取出，如果为0，不管。如果不为0，则计算当前位与a的乘积
		}
		return mystery1(a+a, b / 2) + a;  //每次返回的值中增加了a，a是此次递归时b的当前位与a的乘积，最后de结果就是所有不为0位的和。
	}
	
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
