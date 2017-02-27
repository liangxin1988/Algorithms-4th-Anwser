package chapter2;

import framework.Title;
import Answer.BaseChapter;
import static edu.princeton.cs.algs4.StdOut.*;

public class Chapter2_2Exercises extends BaseChapter{

	@Title("2.2.8")
	public static void question8(){
		println("代码参考MergeSortFaster中的sort方法");
		println("证明：");
		println("由于对于有序数组，a[mid] <= a[mid + 1]恒成立，所以整个排序过程merge并不会执行。所以比较次数与sort()方法的执行次数一致（每次执行sort执行且只执行一次比较）");
		println("sort()方法在第一次调用的时候被调用了一次，而每个sort()方法中会调用两次sort()，所以调用次数最多为1 + 2 + 4 + 8 ... + n/2 = n - 1 ~ n");
	}
	
	@Title("2.2.9")
	public static void question9(){
		println("参考MergeSort中的代码");
	}
}
