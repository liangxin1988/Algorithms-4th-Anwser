package sort;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


/**
 * 排序算法的基类，定义了一些通用的方法和测试方法
 * */
public abstract class BaseSort {
	
	protected Comparable[] a;
	
	public BaseSort(Comparable[] a){
		this.a = a;
	}

	/**
	 * 实现排序的方法。排序类的主要目的，就是通过继承重写这个方法，以便于实现一种不同的排序算法
	 * */
	public abstract void sort();
	
	/**
	 * 对两个可比较对象进行比较。如果a<b则返回true，否则返回false
	 * 比较是排序的基础，排序算法通过比较才能知道应该将哪个元素放在前面，那个元素放在后面
	 * */
	protected boolean less(Comparable a,Comparable b){
		return a.compareTo(b) < 0;
	}
	
	/**
	 * 交换数组中的连个元素的位置
	 * 交换也是排序非常重要的一种方式（但不是必须）。通过交还，更改数组中元素的位置，使其按照规则进行重新排列
	 * */
	protected void exch(Comparable[] x,int a,int b){
		Comparable t = x[a];
		x[a] = x[b];
		x[b] = t;
	}
	
	/**
	 * 打印一个数组
	 * */
	public void show(){
		StdOut.println(Arrays.toString(a));
	}
	
	/**
	 * 判断数组是否已经有序
	 * */
	public boolean isSorted(){
		for(int i = 1;i<a.length;i++){
			if(less(a[i],a[i - 1])){
				return false;
			}
		}
		return true;
	}

}
